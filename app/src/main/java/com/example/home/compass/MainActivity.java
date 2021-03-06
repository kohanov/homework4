package com.example.home.compass;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Compass compass;
    private SensorManager manager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compass = (Compass) findViewById(R.id.compass);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(compass);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(compass, sensor, SensorManager.SENSOR_DELAY_UI);
    }
}
