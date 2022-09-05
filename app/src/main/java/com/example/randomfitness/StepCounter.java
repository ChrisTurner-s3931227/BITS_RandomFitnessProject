package com.example.randomfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class StepCounter extends AppCompatActivity implements SensorEventListener {

    private TextView stepCounterDisplay;
    private SensorManager sensorMan;
    private Sensor mStepCounter;
    private boolean stepCounterPresent;
    int stepCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);


        stepCounterDisplay = findViewById(R.id.id_stepCounter);
        sensorMan = (SensorManager)getSystemService(SENSOR_SERVICE);

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

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter) {
            stepCount = stepCount + 1;
            stepCounterDisplay.setText(String.valueOf(stepCount));
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