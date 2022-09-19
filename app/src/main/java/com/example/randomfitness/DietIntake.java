package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DietIntake extends AppCompatActivity {

    private EditText breakfast;
    private EditText lunch;
    private EditText dinner;
    private EditText snacks;

    private TextView intake;

    private boolean isInvalidNum = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_intake);

        breakfast = (EditText) findViewById(R.id.breakfasttext);
        lunch = (EditText) findViewById(R.id.lunchtext);
        dinner = (EditText) findViewById(R.id.dinnertext);
        snacks = (EditText) findViewById(R.id.snacktext);

        intake = (TextView) findViewById(R.id.dailytotaltextView);

        Button logintake = (Button) findViewById(R.id.intakebutton);

        logintake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailyintake();
            }
        });
    }

    private void dailyintake() {
        double breakfastintake = Double.valueOf(breakfast.getText().toString());
        double lunchintake = Double.valueOf(lunch.getText().toString());
        double dinnerintake = Double.valueOf(dinner.getText().toString());
        double snackintake = Double.valueOf(snacks.getText().toString());


        double result = breakfastintake + lunchintake + dinnerintake + snackintake;
        intake.setText("Daily Intake: " + Math.round(result));
    }

    public void goToDietSettings (View view){
        Intent intent = new Intent (this, DietSettings.class);
        startActivity(intent);
    }
}