package com.example.mnemonica;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    Button button;
    EditText edit;
    TextView displayText;
    String inputString;
    Intent intentResult;

    int correctCount = 0;
    int count = 0;
    int inputInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        displayText = findViewById(R.id.displayText);
        edit = findViewById(R.id.InputText);
        button = findViewById(R.id.btnEnterText);

        //tamariz stack array
        String[] tamariz = {"4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦"};

        final List<String> stack = new LinkedList<>(Arrays.asList(tamariz));

        final ArrayList<Integer> position =new ArrayList<Integer>();

        for (int j = 0; j <= 52; j++){
            position.add(j+1);
        }

        button.setEnabled(false);
        edit.setError("Cannot be empty");

        displayText.setText(stack.get(count));

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
            //if user inputs correct position of card +1 to count
            @Override
            public void onClick(View v) {
                /*
                get input from edittext. if it is equal to random+1 increment count
                then generate new random number from stack size.
                display new card. remove card from stack.

                keep a count. if it gets to 52 go to results page
                */
                count++;

                inputString = edit.getText().toString();
                inputInt = Integer.parseInt(inputString);

                if(inputInt == position.get(count)-1){
                    correctCount++;
                }

                edit.getText().clear();

                if(count > 51){
                    intentResult = new Intent(TestActivity.this, ResultActivity.class);
                    intentResult.putExtra("val", correctCount);
                    startActivity(intentResult);
                }else{
                    displayText.setText(stack.get(count));
                }
            }
        });
    }
}