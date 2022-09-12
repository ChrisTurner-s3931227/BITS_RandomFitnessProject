package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StepCounter extends AppCompatActivity implements SensorEventListener {

    private TextView stepCounterDisplay, date, distanceDisplay;
    private SensorManager sensorMan;
    private Sensor mStepCounter;
    private boolean stepCounterPresent;
    int stepCount = -1;
    double totalDistance = 0.00;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);


        Intent intent = getIntent();
        String name = intent.getStringExtra(WelcomeScreen.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.id_sc_username);
        textView.setText(name);



        distanceDisplay = findViewById(R.id.id_distance);

        Date currentTime = Calendar.getInstance().getTime();

        SimpleDateFormat yearf = new SimpleDateFormat("yyyy");
        SimpleDateFormat dayf = new SimpleDateFormat("dd");
        SimpleDateFormat daylongf = new SimpleDateFormat("EEEE");
        SimpleDateFormat monthlongf = new SimpleDateFormat("MMMM");

        Date currentDate = new Date();
        String theYear = yearf.format(currentDate);
        String theMonthLong = monthlongf.format(currentDate);
        String theDay = dayf.format(currentDate);
        String theDayLong = daylongf.format(currentDate);

        date = findViewById(R.id.id_todaysDate);
        date.setText(String.valueOf("It is " + theDayLong + " the " + theDay +  " of " + theMonthLong + ", " + theYear));


        stepCounterDisplay = findViewById(R.id.id_stepCounter);
        sensorMan = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Permissions, needed to get it working
        if(sensorMan.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {  //If a step is detected
            mStepCounter = sensorMan.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            stepCounterPresent = true;
        }
        else {
            stepCounterPresent = false;
        }

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);

        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    //Permissions end

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter) {

            stepCount = stepCount + 1;
            stepCounterDisplay.setText(String.valueOf(stepCount + " steps"));

            totalDistance =  stepCount / 1320.00;
            distanceDisplay.setText(String.format("%.2f", totalDistance) + "km");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(sensorMan.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            sensorMan.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onPause() {
        super.onPause();
        if(sensorMan.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            sensorMan.unregisterListener(this, mStepCounter);
        }

    }
}