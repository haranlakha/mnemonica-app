package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class StackActivity extends AppCompatActivity {

    int count = 0;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        String[] tamariz = {"4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦"};

        final List<String> stack = Arrays.asList(tamariz);

        button = findViewById(R.id.newCardbtn);
        textView = findViewById(R.id.textView);

        textView.setText(stack.get(count));

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                count++;
                if(count == 51){
                    textView.setText(stack.get(count));
                    button.setText("Main Menu");
                } else if(count == 52){
                    Intent intentMenu = new Intent(StackActivity.this, MainActivity.class);
                    startActivity(intentMenu);
                } else {
                    textView.setText(stack.get(count));
                }
            }
        });
    }
}
