package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstTime extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.randomfitness.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        EditText editText = (EditText) findViewById(R.id.id_yourName);
        String name = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }



}