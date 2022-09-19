package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.randomfitness.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra(FirstTime.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.id_sc_username);
        textView.setText(name);


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, StepCounter.class);
        TextView textView = (TextView) findViewById(R.id.id_sc_username);
        String name = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }


}