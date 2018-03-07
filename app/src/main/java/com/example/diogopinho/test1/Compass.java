package com.example.diogopinho.test1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Compass extends AppCompatActivity implements SensorEventListener {
    private ImageView compassImage;
    private TextView infoTextAboutDegrees;
    public float initialDegree = 0f;
    private SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        compassImage = findViewById(R.id.imageViewCompass);

        infoTextAboutDegrees = findViewById(R.id.tvHeading);

        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();

        manager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        float currentDegree = Math.round(event.values[0]);

        infoTextAboutDegrees.setText("Current degrees: " + Float.toString(currentDegree));

        RotateAnimation rotateAnimation = new RotateAnimation(
                initialDegree,
                -currentDegree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);

        rotateAnimation.setDuration(210);

        rotateAnimation.setFillAfter(true);

        compassImage.startAnimation(rotateAnimation);
        initialDegree = -currentDegree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}