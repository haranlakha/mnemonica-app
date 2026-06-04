package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

public class StackActivity extends AppCompatActivity {

    int count = 0;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        final List<String> stack = MnemonicaStack.getStack();

        button = findViewById(R.id.newCardbtn);
        textView = findViewById(R.id.textView);

        textView.setText((count+1) + "    " + stack.get(count));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count++;
                if(count == 51){
                    textView.setText((count+1) + "    " + stack.get(count));
                    button.setText("Main Menu");
                } else if(count == 52){
                    Intent intentMenu = new Intent(StackActivity.this, MainActivity.class);
                    startActivity(intentMenu);
                } else {
                    textView.setText((count+1) + "    " + stack.get(count));
                }
            }
        });
    }
}
