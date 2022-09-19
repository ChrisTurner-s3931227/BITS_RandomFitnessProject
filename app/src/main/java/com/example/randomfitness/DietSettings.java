package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import java.text.DecimalFormat;

public class DietSettings extends AppCompatActivity {

    private EditText heightinput;
    private EditText weightinput;
    private EditText goalinput;

    private TextView bmiresult;
    private TextView maintenanceresult;
    private TextView budgetresult;

    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_settings);

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
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (heightinput.getText().toString().isEmpty() || weightinput.getText().toString().isEmpty() ||
                        spinner.getSelectedItem().toString().equals("Please Select Desired Rate")) {
                    Toast.makeText(DietSettings.this, "Please fill out all fields and select desired rate.", Toast.LENGTH_LONG).show();
                }


                if (!heightinput.getText().toString().isEmpty() && !weightinput.getText().toString().isEmpty() &&
                        !spinner.getSelectedItem().toString().equals("Please Select Desired Rate"))
                {

                    if (spinner.getSelectedItem().toString().equals("Gain 1kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = 25;
                        double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                        double budget = result + 4602.4;
                        budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                    } else if (spinner.getSelectedItem().toString().equals("Gain 0.5kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = 25;
                        double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                        double budget = result + 2301.2;
                        budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                    } else if (spinner.getSelectedItem().toString().equals("Maintain Current Weight")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = 25;
                        double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                        budgetresult.setText("Daily kJ Budget: " + Math.round(result));
                    } else if (spinner.getSelectedItem().toString().equals("Lose 0.5kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = 25;
                        double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                        double budget = result - 2301.2;
                        budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                    } else if (spinner.getSelectedItem().toString().equals("Lose 1kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = 25;
                        double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                        double budget = result - 4602.4;
                        budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                    } else {
                        budgetresult.setText("Daily kJ Budget: ");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                budgetresult.setText("Daily kJ Budget: ");
            }
        });

    }

    private void bmiCalculation() {

        if (heightinput.getText().toString().isEmpty() || weightinput.getText().toString().isEmpty()) {
            Toast.makeText(DietSettings.this, "Please enter a number!", Toast.LENGTH_LONG).show();
        }

        if (!heightinput.getText().toString().isEmpty() && !weightinput.getText().toString().isEmpty()) {
            double height = Double.valueOf(heightinput.getText().toString());
            double weight = Double.valueOf(weightinput.getText().toString());
            double result = weight / ((height * height) / 10000);
            DecimalFormat df = new DecimalFormat("##.##");

            bmiresult.setText("BMI: " + df.format(result));
        }
    }

    private void maintenanceCalculation() {

        if (heightinput.getText().toString().isEmpty() || weightinput.getText().toString().isEmpty()) {
            Toast.makeText(DietSettings.this, "Please enter a number!", Toast.LENGTH_LONG).show();
        }

        if (!heightinput.getText().toString().isEmpty() && !weightinput.getText().toString().isEmpty()) {
            double height = Double.valueOf(heightinput.getText().toString());
            double weight = Double.valueOf(weightinput.getText().toString());
            double age = 25;
            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
            maintenanceresult.setText("Weight Maintenance kJ: " + Math.round(result));
        }
    }

    public void goToDietIntake (View view){
        Intent intent = new Intent (this, DietIntake.class);
        startActivity(intent);
    }

    public void goToStepCounter (View view){
        Intent intent = new Intent (this, StepCounter.class);
        startActivity(intent);
    }
}