package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        int value = 0;
        if (extras != null) {
            value = extras.getInt("val");
        }

        TextView correctResult = findViewById(R.id.correctResultTextView);
        correctResult.setTextColor(Color.parseColor("#008000"));
        correctResult.setText("Correct: " + String.valueOf(value));

        TextView incorrectResult = findViewById(R.id.incorrectResultTextView);
        incorrectResult.setTextColor(Color.parseColor("#FF0000"));
        incorrectResult.setText("Incorrect: " + String.valueOf(52 - value));

        Button resultButton = findViewById(R.id.resultMenuButton);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultMenu = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(resultMenu);
            }
        });

    }
}