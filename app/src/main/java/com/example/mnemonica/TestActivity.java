package com.example.mnemonica;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class TestActivity extends AppCompatActivity {

    Button button;
    EditText input;
    TextView displayText;
    String inputString;
    Intent intentResult;

    int correctCount = 0;
    int incorrectCount = 0;
    int count = 0;
    int inputInt = 0;

    boolean checkResults = false;

    final ArrayList<Integer> position = new ArrayList<>();
    final List<String> correctGuess = new LinkedList<>();
    final List<String> incorrectGuess = new LinkedList<>();

    long seed = System.nanoTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        displayText = findViewById(R.id.displayText);
        input = findViewById(R.id.InputText);
        button = findViewById(R.id.btnEnterText);

        //tamariz stack array
        String[] tamariz = {"4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦"};

        final List<String> stack = new LinkedList<>(Arrays.asList(tamariz));

        for (int j = 0; j < 52; j++){
            position.add(j+1);
        }

        final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        final AlertDialog.Builder guessesDialog = new AlertDialog.Builder(this);
        final AlertDialog.Builder resultsDialog = new AlertDialog.Builder(this);

        resultsDialog.setCancelable(false);

        Collections.shuffle(stack, new Random(seed));
        Collections.shuffle(position, new Random(seed));

        button.setEnabled(false);
        input.setError("Cannot be empty");

        displayText.setText(stack.get(count));

        input.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0){
                    input.setError("Cannot be empty");
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
                    inputString = input.getText().toString();
                    inputInt = Integer.parseInt(inputString);

                    //input is correct
                    if(inputInt == position.get(count)){
                        guessesDialog.setMessage("Correct!");
                        correctGuess.add(stack.get(count));
                        correctCount++;
                    }else{
                        //input is incorrect
                        guessesDialog.setMessage("Incorrect!");
                        incorrectGuess.add(stack.get(count));
                        incorrectCount++;
                    }
                    guessesDialog.show();
                }

                count++;
                input.getText().clear();

                if(count > 51){
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    button.setVisibility(View.INVISIBLE);
                    displayText.setVisibility(View.INVISIBLE);
                    input.setVisibility(View.INVISIBLE);
                    intentResult = new Intent(TestActivity.this, MainActivity.class);

                    resultsDialog.setMessage("Correct: " + correctCount + "\nIncorrect: " + (52 - correctCount));
                    for(int i = 0; i < correctGuess.size(); i++){
                        resultsDialog.setMessage(correctGuess.get(i) + "\n");
                    }

                    resultsDialog.setPositiveButton(
                        "Menu",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(intentResult);
                            }
                        }
                    );
                    resultsDialog.show();
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