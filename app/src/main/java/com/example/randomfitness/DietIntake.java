package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DietIntake extends AppCompatActivity {

    EditText breakfast;
    EditText lunch;
    EditText dinner;
    EditText snacks;

    TextView intake;

    ListView testlist;

    ArrayAdapter arrayAdapter;

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

        testlist = (ListView) findViewById(R.id.testlist);

        Button logintake = (Button) findViewById(R.id.intakebutton);
        Button viewlist = (Button) findViewById(R.id.viewlistbutton);

        logintake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntakeModel intakeModel;

                try {
                    intakeModel = new IntakeModel(Integer.parseInt(breakfast.getText().toString()), Integer.parseInt(lunch.getText().toString()), Integer.parseInt(dinner.getText().toString()), Integer.parseInt(snacks.getText().toString()));
                    Toast.makeText(DietIntake.this, intakeModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(DietIntake.this, "Error creating intake", Toast.LENGTH_SHORT).show();
                    intakeModel = new IntakeModel(-1, -1, -1, -1);
                }

                DatabaseIntake databaseIntake = new DatabaseIntake(DietIntake.this);

                boolean success = databaseIntake.addOne(intakeModel);
                Toast.makeText(DietIntake.this, "Success: " + success, Toast.LENGTH_SHORT).show();

            }
        });

        viewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseIntake databaseIntake = new DatabaseIntake(DietIntake.this);
                List<IntakeModel> all = databaseIntake.getAll();

                arrayAdapter = new ArrayAdapter<IntakeModel>(DietIntake.this, android.R.layout.simple_list_item_1, all);
                testlist.setAdapter(arrayAdapter);

                Toast.makeText(DietIntake.this, all.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    // private void dailyintake() {
    //    double breakfastintake = Double.valueOf(breakfast.getText().toString());
    //    double lunchintake = Double.valueOf(lunch.getText().toString());
    //    double dinnerintake = Double.valueOf(dinner.getText().toString());
    //    double snackintake = Double.valueOf(snacks.getText().toString());
    //    double result = breakfastintake + lunchintake + dinnerintake + snackintake;
    //    intake.setText("Daily Intake: " + Math.round(result));
    //}

    public void goToDietSettings (View view){
        Intent intent = new Intent (this, DietSettings.class);
        startActivity(intent);
    }
}
