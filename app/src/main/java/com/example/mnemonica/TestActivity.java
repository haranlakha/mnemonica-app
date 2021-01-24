package com.example.mnemonica;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.security.AccessController.getContext;

public class TestActivity extends AppCompatActivity {

    Button button;
    EditText edit;
    TextView displayText;
    String inputString;
    Intent intentResult;

    int correctCount = 0;
    int count = 0;
    int inputInt = 0;

    boolean checkResults = false;
    
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

        for (int j = 0; j < 52; j++){
            position.add(j+1);
        }

        long seed = System.nanoTime();

        final AlertDialog.Builder builder = new AlertDialog.Builder(this); //dialog for correct/incorrect guesses
        final AlertDialog.Builder results = new AlertDialog.Builder(this); //dialog for showing results to user

        final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        Collections.shuffle(stack, new Random(seed));
        Collections.shuffle(position, new Random(seed));
        button.setEnabled(false);
        edit.setError("Cannot be empty");

        displayText.setText(stack.get(count));


            edit.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().trim().length() == 0 && checkResults){
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
            @Override
            public void onClick(View v) {

                if(!checkResults){
                    inputString = edit.getText().toString();
                    inputInt = Integer.parseInt(inputString);

                    if(inputInt == position.get(count)){
                        correctCount++; //increment correct count
                        //if input is correct
                        builder.setMessage("Correct!");

                    }else{
                        //if input is incorrect
                        builder.setMessage("Incorrect!");
                    }
                    builder.show();
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }


                count++;
                edit.getText().clear();

                if(count > 51){
                    //when end of list is reached go to results screen, passing in the number of correct guesses

                    intentResult = new Intent(TestActivity.this, MainActivity.class);

                    if(!checkResults){
                        results.setMessage("Correct: " + correctCount + "\nIncorrect: " + (52 - correctCount));
                    }
                    results.setPositiveButton(
                        "Menu",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(intentResult);
                            }
                        }
                    );

                    results.show();
                    checkResults = true;

                }else if(count == 51){
                    //on last screen the button text is changed
                    button.setText("Results");
                    displayText.setText(stack.get(count));
                }else {
                    displayText.setText(stack.get(count));
                }
            }
        });
    }
}