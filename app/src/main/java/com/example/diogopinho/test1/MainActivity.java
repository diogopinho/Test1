package com.example.diogopinho.test1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Map map = new Map();
        Node sala101 = new Node ("Sala 101");
        sala101.setFloor(1);
        sala101.setQR(false);
        Node sala102 = new Node("Sala 102");
        sala102.setFloor(1);
        sala102.setQR(false);
        Arc lig101_102 = new Arc(sala101,sala102,5);
        sala101.addAdjacent(lig101_102);
        sala102.addAdjacent(lig101_102);
        System.out.println(sala101.getLabel());
        System.out.println(sala101.getFloor());
        
        Node pontoC11 = new Node("Ponto C11");
        pontoC11.setFloor(1);
        Node pontoC12 = new Node("Ponto C12");
        pontoC12.setFloor(1);
        map.addNode(sala101);
        map.addNode(sala102);
        map.addNode(pontoC11);
        map.addNode(pontoC12);
        map.addArc(pontoC11, sala101, 3);
        map.addArc(sala101, sala102, 2);
        map.addArc(sala102, pontoC12, 3);

        ///////////////////////////////////////////////////////

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button scan_btn = findViewById(R.id.scan_btn);
        Button compass = findViewById(R.id.compass);
        text1 = findViewById(R.id.text1);
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
        compass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Compass.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null) {
            if(result.getContents()==null) {
                text1.setText(R.string.scan_cancel);
            }
            else {
                text1.setText(result.getContents());
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
