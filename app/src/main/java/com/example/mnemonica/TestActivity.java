package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        String[] tamariz = {"4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                            "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                            "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                            "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦"};
        final List<String> stack = new LinkedList<>(Arrays.asList(tamariz));

        int numbers[] ={1,2,3,4,5,6,7,8,9,10,
                        11,12,13,14,15,16,17,18,19,20,
                        21,22,23,24,25,26,27,28,29,30,
                        31,32,33,34,35,36,37,38,39,40,
                        41,42,43,44,45,46,47,48,49,50,
                        51,52};

        final ArrayList<Integer> position =new ArrayList<Integer>();

        for (int i = 0; i <= numbers.length; i++){
            position.add(i);
        }

        Random rand = new Random();
        final int random1 = rand.nextInt(stack.size());
        displayText.setText(stack.get(random1));
        stack.remove(random1);
        position.remove(random1);

        Button button = (Button)findViewById(R.id.btnEnterText);

        button.setOnClickListener(new View.OnClickListener() {
           Random rand2 = new Random();
            @Override
            public void onClick(View v) {

                int random2 = rand2.nextInt(stack.size());
                    displayText.setText(stack.get(random2));
                    stack.remove(random2);
                    position.remove(random2);

            }
        });
    }

}

