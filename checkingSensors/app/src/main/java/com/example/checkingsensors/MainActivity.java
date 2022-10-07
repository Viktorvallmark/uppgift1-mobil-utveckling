package com.example.checkingsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

      SensorManager manager;
      Sensor sensor;
      TextView xvalue, yvalue, zvalue;
      boolean clicked;


    SensorEventListener eventListener = new SensorEventListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            xvalue.setText("x: " + values[0]+"\n");
            yvalue.setText("y: " + values[1]+"\n");
            zvalue.setText("z: " + values[2]+"\n");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicked = false;

        xvalue= findViewById(R.id.textView);
        yvalue= findViewById(R.id.textView2);
        zvalue= findViewById(R.id.textView3);
        Button b = (Button) findViewById(R.id.button);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> list = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if(list.size()>0){
            manager.registerListener(eventListener, list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Log.i("viktor", "No accelerometer in the device!");
        }

        b.setOnClickListener(e -> {
            Toast.makeText(this, "Hejsan", Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    protected void onStop(){
        manager.unregisterListener(eventListener);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}