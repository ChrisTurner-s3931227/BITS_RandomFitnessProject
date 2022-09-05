package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterButton = findViewById(R.id.id_welcomeButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StepCounterStart();
                }
            }
        );
    }

    public void StepCounterStart() {
        Intent intent = new Intent(this, StepCounter.class);
        startActivity(intent);
    }
}