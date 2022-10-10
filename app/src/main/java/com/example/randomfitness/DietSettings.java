package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class DietSettings extends AppCompatActivity {

    private EditText heightinput;
    private EditText weightinput;
    private EditText goalinput;
    private EditText ageinput;

    private TextView bmiresult;
    private TextView maintenanceresult;
    private TextView budgetresult;

    private Spinner spinner;

    private Switch measurementswitch;
    private Switch energyswitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_settings);

        heightinput = (EditText) findViewById(R.id.textheight);
        weightinput = (EditText) findViewById(R.id.textinitialweight);
        goalinput = (EditText) findViewById(R.id.goalweighttext);
        ageinput = (EditText) findViewById(R.id.textinitialage);

        Button logsettings = (Button) findViewById(R.id.logbutton);

        bmiresult = (TextView) findViewById(R.id.bmitext);
        maintenanceresult = (TextView) findViewById(R.id.maintenancetext);
        budgetresult = (TextView) findViewById(R.id.budgettext);

        spinner = (Spinner) findViewById(R.id.weightratespinner);

        measurementswitch = (Switch) findViewById(R.id.measurementswitch);
        energyswitch = (Switch) findViewById(R.id.energyswitch);

        logsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (heightinput.getText().toString().isEmpty() || weightinput.getText().toString().isEmpty()) {
                    Toast.makeText(DietSettings.this, "Please enter a number!", Toast.LENGTH_LONG).show();
                }


                if (!heightinput.getText().toString().isEmpty() && !weightinput.getText().toString().isEmpty()) {
                    double height = Double.valueOf(heightinput.getText().toString());
                    double weight = Double.valueOf(weightinput.getText().toString());
                    double age = Double.valueOf(ageinput.getText().toString());

                    if (measurementswitch.isChecked()) {
                        double bmi = (weight / (height * height)) * 703;
                        DecimalFormat df = new DecimalFormat("##.##");
                        bmiresult.setText("BMI: " + df.format(bmi));
                    } else {
                        double bmi = (weight / (height * height)) * 10000;
                        DecimalFormat df = new DecimalFormat("##.##");
                        bmiresult.setText("BMI: " + df.format(bmi));
                    }

                    if (energyswitch.isChecked()) {
                        double maintenance = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100)));
                        maintenanceresult.setText("Weight Maintenance Cal: " + Math.round(maintenance));
                    } else {
                        double maintenance = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                        maintenanceresult.setText("Weight Maintenance kJ: " + Math.round(maintenance));
                    }

                }


                if (!heightinput.getText().toString().isEmpty() && !weightinput.getText().toString().isEmpty() &&
                        !spinner.getSelectedItem().toString().equals("Please Select Desired Rate"))
                {

                    if (spinner.getSelectedItem().toString().equals("Gain 1kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = Double.valueOf(ageinput.getText().toString());
                        if (energyswitch.isChecked()) {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100)));
                            double budget = result + 1100;
                            budgetresult.setText("Daily Cal Budget: " + Math.round(budget));
                        } else {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                            double budget = result + 4602.4;
                            budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                        }
                    } else if (spinner.getSelectedItem().toString().equals("Gain 0.5kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = Double.valueOf(ageinput.getText().toString());
                        if (energyswitch.isChecked()) {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100)));
                            double budget = result + 550;
                            budgetresult.setText("Daily Cal Budget: " + Math.round(budget));
                        } else {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                            double budget = result + 2301.2;
                            budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                        }
                    } else if (spinner.getSelectedItem().toString().equals("Maintain Current Weight")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = Double.valueOf(ageinput.getText().toString());
                        if (energyswitch.isChecked()) {
                            double budget = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100)));
                            budgetresult.setText("Daily Cal Budget: " + Math.round(budget));
                        } else {
                            double budget = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                            budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                        }
                    } else if (spinner.getSelectedItem().toString().equals("Lose 0.5kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = Double.valueOf(ageinput.getText().toString());
                        if (energyswitch.isChecked()) {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100)));
                            double budget = result - 550;
                            budgetresult.setText("Daily Cal Budget: " + Math.round(budget));
                        } else {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                            double budget = result - 2301.2;
                            budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                        }
                    } else if (spinner.getSelectedItem().toString().equals("Lose 1kg per Week")) {
                        double height = Double.valueOf(heightinput.getText().toString());
                        double weight = Double.valueOf(weightinput.getText().toString());
                        double age = Double.valueOf(ageinput.getText().toString());
                        if (energyswitch.isChecked()) {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100)));
                            double budget = result - 1100;
                            budgetresult.setText("Daily Cal Budget: " + Math.round(budget));
                        } else {
                            double result = (1086 - (10.1 * age) + (13.7 * weight) + (416 * (height / 100))) * 4.184;
                            double budget = result - 4602.4;
                            budgetresult.setText("Daily kJ Budget: " + Math.round(budget));
                        }
                    } else {
                        budgetresult.setText("Daily kJ Budget: ");
                    }
                }
            }



        });

    }

    public void goToStepCounter (View view){
        Intent intent = new Intent (this, StepCounter.class);
        startActivity(intent);
    }
}