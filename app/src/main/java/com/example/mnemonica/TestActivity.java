package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity {
    //global variables
    Button button;
    EditText edit;
    int textInt;
    int random1;
    int random2;
    int count = 0;
    int totalCount = 0;

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

        int[] numbers = new int[52];
        //filling the numbers array
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i+1;
        }

        final ArrayList<Integer> position =new ArrayList<Integer>();

        for (int j = 0; j <= numbers.length; j++){
            position.add(j);
        }

        Random rand = new Random();
        random1 = rand.nextInt(stack.size());
        displayText.setText(stack.get(random1));
        stack.remove(random1);
        position.remove(random1);

        edit = findViewById(R.id.InputText);
        button = findViewById(R.id.btnEnterText);

        button.setEnabled(false);
        edit.setError("Cannot be empty");

        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0){
                    edit.setError("Cannot be empty");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            Random rand2 = new Random();
            @Override
            public void onClick(View v) {
                if(totalCount == 52){
                    Intent intentResult = new Intent(TestActivity.this, ResultActivity.class);
                    int value = count;
                    intentResult.putExtra("val", value);
                    startActivity(intentResult);
                }
                String text = edit.getText().toString();
                textInt = Integer.parseInt(text);

                random2 = rand2.nextInt(stack.size());
                displayText.setText(stack.get(random2));

                stack.remove(random2);
                position.remove(random2);

                if (textInt == random1+1 || textInt == random2+1){
                    count += 1;
                }
                edit.getText().clear();
                button.setEnabled(false);
                totalCount +=1;

            }
        });
    }

}

