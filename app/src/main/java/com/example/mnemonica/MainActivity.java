package com.example.mnemonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void goToStudyActivity (View view){
        Intent intent = new Intent (this, StudyActivity.class);
        startActivity(intent);
    }
    public void goToGenerator (View view){
        Intent intent = new Intent (this, GeneratorActivity.class);
        startActivity(intent);
    }
    public void goToTest (View view){
        Intent intent = new Intent (this, TestActivity.class);
        startActivity(intent);
    }

}
