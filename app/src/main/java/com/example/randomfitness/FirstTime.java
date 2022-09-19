package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstTime extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.randomfitness.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);

    }

    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.id_yourName);
        String name = editText.getText().toString();

        if (!name.toString().matches("[a-zA-z]+")) {
            Toast.makeText(FirstTime.this, "Name cannot have special characters or spaces!", Toast.LENGTH_LONG).show();
        }

        if (name.toString().matches("[a-zA-z]+")) {
            Intent intent = new Intent(this, WelcomeScreen.class);
            intent.putExtra(EXTRA_MESSAGE, name);
            startActivity(intent);
        }

    }

}