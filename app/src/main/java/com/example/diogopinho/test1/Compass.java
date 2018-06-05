package com.example.diogopinho.test1;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class Compass extends AppCompatActivity implements SensorEventListener {
    private ImageView compassImage;
    private TextView infoTextAboutDegrees;
    public float initialDegree = 0f;
    private SensorManager manager;
    private static int orientation;
    Stack<DirectedEdge> path;
    DirectedEdge de;
    Map map;
    Global global;
    EdgeWeightedDigraph graph;
    String destino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        compassImage = findViewById(R.id.imageViewCompass);
        infoTextAboutDegrees = findViewById(R.id.tvHeading);
        Button next_btn = findViewById(R.id.next_btn);
        Button scan_btn = findViewById(R.id.scan_btn);
        Button done_btn = findViewById(R.id.done_btn);

        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        global = (Global)getApplicationContext();
        map = global.getMap();
        graph = global.getGraph();
        path = (Stack<DirectedEdge>) global.getDirection();
        de = path.pop();

        Arc arc = map.findArc(de.from(), de.to()).get(0);
        getPassos();
        getArcOrientation();

        Intent intent = getIntent();
        destino=intent.getStringExtra("destino");

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while(!(path.isEmpty())) {
                    de=path.pop();
                    if(map.findNodeId(de.from()).isQR()) {
                        getPassos();
                        getArcOrientation();
                        break;
                    }
                }
                if(path.isEmpty()) {
                    infoTextAboutDegrees.setText("Daqui a " + getPassos() + " passos chegou ao seu destino.");
                }
            }
        });

        final Activity activity = this;

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setOrientationLocked(true);
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.setCaptureActivity(CaptureActivityPortrait.class);
                integrator.initiateScan();
            }
        });

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Compass.this.onBackPressed();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null) {
            if(result.getContents()==null) {
                Toast.makeText(this,"Scan cancelado",Toast.LENGTH_SHORT).show();

            }
            else {
                while(!(path.isEmpty())) {
                    de=path.pop();
                    if(map.findNodeId(de.from()).isQR()) {
                        if(map.findNodeId(de.from()).getLabel().equals(result.getContents())) {
                            getPassos();
                            getArcOrientation();
                            break;
                        }
                        else {
                            global.setDirection(map.direcoes(result.getContents(), destino,graph, map));
                        }
                    }
                }
                if(path.isEmpty()) {
                    infoTextAboutDegrees.setText("Daqui a " + getPassos() + " passos chegou ao seu destino.");
                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void getArcOrientation() {
        Arc arc = map.findArc(de.from(), de.to()).get(0);
        if (arc.getNode1().getId() != de.from()) {
            orientation = arc.getOrientacion() + 180;
        } else {
            orientation = arc.getOrientacion();
        }
    }

    private int getPassos() {
        int count=(int)de.weight();
        for (DirectedEdge de: path) {
            if(map.findNodeId(de.from()).isQR()) {
                    infoTextAboutDegrees.setText("Siga a seta durante " + count + " passos ate a " + map.findNodeId(de.from()).getLabel());
                    return count;
            }
            count+=(int)de.weight();
        }
        return count;
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


        float currentDegree = Math.round(event.values[0])-orientation;

        //infoTextAboutDegrees.setText("Current degrees: " + Float.toString(currentDegree));

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