package com.example.fitnessappdietfuntions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText heightinput;
    private EditText weightinput;
    private EditText goalinput;

    private TextView bmiresult;
    private TextView maintenanceresult;
    private TextView budgetresult;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightinput = (EditText) findViewById(R.id.textheight);
        weightinput = (EditText) findViewById(R.id.textinitialweight);
        goalinput = (EditText) findViewById(R.id.goalweighttext);

        Button logheight = (Button) findViewById(R.id.heightbutton);
        Button logweight = (Button) findViewById(R.id.initialweightbutton);
        Button loggoal = (Button) findViewById(R.id.goalweightbutton);

        bmiresult = (TextView) findViewById(R.id.bmitext);
        maintenanceresult = (TextView) findViewById(R.id.maintenancetext);
        budgetresult = (TextView) findViewById(R.id.budgettext);

        spinner = (Spinner) findViewById(R.id.weightratespinner);

        logheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiCalculation();
            }
        });

        logweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiCalculation();
            }
        });

        loggoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maintenanceCalculation();
                budgetCalculation();
            }
        });


    }

    private void bmiCalculation() {
        double height = Double.valueOf(heightinput.getText().toString());
        double weight = Double.valueOf(weightinput.getText().toString());
        double result = weight / ((height * height) / 10000);
        DecimalFormat df = new DecimalFormat("##.##");
        bmiresult.setText("BMI: " + df.format(result));
    }

    private void maintenanceCalculation() {
        double height = Double.valueOf(heightinput.getText().toString());
        double weight = Double.valueOf(weightinput.getText().toString());
        double age = 25;
        double result = (10 * weight) + (6.25 * (height / 100)) - (5 * age) + 5;
        maintenanceresult.setText("Weight Maintenance kJ: " + Math.round(result));
    }

    private void budgetCalculation() {
        double height = Double.valueOf(heightinput.getText().toString());
        double weight = Double.valueOf(weightinput.getText().toString());
        double age = 25;
        double result = ((10 * weight) + (6.25 * height) - (5 * age) + 5) * 4.1868;
        budgetresult.setText("Weight Maintenance kJ: " + Math.round(result));
    }

    public void goToMainActivity2 (View view){
        Intent intent = new Intent (this, MainActivity2.class);
        startActivity(intent);
    }
}