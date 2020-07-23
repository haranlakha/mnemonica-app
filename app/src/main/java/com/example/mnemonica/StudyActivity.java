package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        List<String> mnemonica = Arrays.asList("4♣", "2♥", "7♦", "3♣", "4♥", "6♦", "A♠", "5♥", "9♠", "2♠", "Q♥", "3♦", "Q♣",
                "8♥", "6♠", "5♠", "9♥", "K♣", "2♦", "J♥", "3♠", "8♠", "6♥", "10♣", "5♦", "K♦",
                "2♣", "3♥", "8♦", "5♣", "K♠", "J♦", "8♣", "10♠", "K♥", "J♣", "7♠", "10♥", "A♦",
                "4♠", "7♥", "4♦", "A♣", "9♣", "J♠", "Q♦", "7♣", "Q♠", "10♦", "6♣", "A♥", "9♦");

        final ArrayList<String> cards = new ArrayList<>();
        cards.addAll(mnemonica);

        final Button button = (Button) findViewById(R.id.newCardbtn);
        final TextView textView = findViewById(R.id.textView);

        final int[] i = {0};
        textView.setText(cards.get(i[0]));
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    i[0] +=1;
                    textView.setText(cards.get(i[0]));

                }
            });

    }
}
