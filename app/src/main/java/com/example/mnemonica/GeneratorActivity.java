package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

        final List<String> stack = MnemonicaStack.getStack();

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
