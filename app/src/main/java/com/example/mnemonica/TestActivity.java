package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
card is shown on screen and input is asked.
if input matches the position of shown card go to next random card.
if not add 1 to counter tracking wrong answers and go to next card.
NOTE
the card displayed has to be removed from the selection of cards after each guess somehow. need to figure this out*/

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final TextView displayText = findViewById(R.id.displayText);
        //tamariz stack array
        List<String> tamariz = Arrays.asList("4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦");
        final ArrayList<String> stack = new ArrayList<>();
        stack.addAll(tamariz);

        Random rand = new Random();
        int random1 = rand.nextInt(52);
        displayText.setText(stack.get(random1));

        final EditText InputText = (EditText) findViewById(R.id.InputText);
        Button button = (Button)findViewById(R.id.btnEnterText);

        button.setOnClickListener(new View.OnClickListener() {
            Random rand2 = new Random();
            @Override
            public void onClick(View v) {
                int random2 = rand2.nextInt(52);
                displayText.setText(stack.get(random2));
            }
        });
    }

}

