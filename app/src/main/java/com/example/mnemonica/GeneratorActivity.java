package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//this activity generates a random card and position. This is used for ACAAN effects.

public class GeneratorActivity extends AppCompatActivity {

    TextView textview;
    Button button;
    Random generator;
    int randomNum1;
    int randomNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        String[] tamariz = {"4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦"};

        final List<String> stack = Arrays.asList(tamariz);

        textview = findViewById(R.id.textCard);
        button = findViewById(R.id.RandomButton);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                generator = new Random();
                randomNum1 = generator.nextInt(stack.size());
                randomNum2 = generator.nextInt(stack.size());
                textview.setText(stack.get(randomNum1) + "    " + Integer.toString(randomNum2 + 1));
            }
        });

    }
}
