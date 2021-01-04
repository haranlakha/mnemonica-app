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
    Random rng1;
    Random rng2;
    int random1;
    int random2;

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
                rng1 = new Random();
                rng2 = new Random();
                random1 = rng1.nextInt(stack.size());
                random2 = rng2.nextInt(stack.size());
                textview.setText(stack.get(random1) + "    " + Integer.toString(random2 + 1));
            }
        });

    }
}
