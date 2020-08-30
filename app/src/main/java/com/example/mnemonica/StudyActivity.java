package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StudyActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    public static int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        i = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        final String[] tamariz = {"4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦"};

        button = findViewById(R.id.newCardbtn);
        textView = findViewById(R.id.textView);


        if(i == 0){
            textView.setText(tamariz[i]);
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i++;
                if(i == 51){
                    textView.setText(tamariz[i]);
                    button.setText("Main Menu");

                } else if(i < 52){

                    textView.setText(tamariz[i]);
                } else {
                    Intent intentMenu = new Intent(StudyActivity.this, MainActivity.class);
                    startActivity(intentMenu);
                }
            }
        });
    }
}
