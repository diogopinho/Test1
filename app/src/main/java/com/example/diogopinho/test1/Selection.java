package com.example.diogopinho.test1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class Selection extends AppCompatActivity {

    AutoCompleteTextView destino;
    AutoCompleteTextView origem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        ArrayList<String> tvText = new ArrayList<>();
        tvText.add("Sala 101");
        tvText.add("Sala 102");
        tvText.add("Sala 103");
        tvText.add("Sala 104");
        tvText.add("Sala 105");
        tvText.add("Sala 106");
        tvText.add("Sala 107");
        tvText.add("Sala 108");
        tvText.add("Sala 109");
        tvText.add("Sala 110");
        tvText.add("Sala 111");
        tvText.add("Sala A2");
        tvText.add("Gabinete 1");
        tvText.add("Gabinete 2");
        tvText.add("Gabinete 3");
        tvText.add("Gabinete 4");
        tvText.add("Gabinete 5");
        tvText.add("Gabinete 6");
        tvText.add("Ponto 1.1");
        tvText.add("Ponto 1.2");
        tvText.add("Ponto 1.3");
        tvText.add("Ponto 1.4");
        tvText.add("Ponto 1.5");
        tvText.add("Ponto 1.6");
        tvText.add("Ponto 2.1");
        destino = findViewById(R.id.autoCompleteTextView);
        origem = findViewById(R.id.autoCompleteTextView2);
        Button scan_btn = findViewById(R.id.scan_btn);
        Button go_btn = findViewById(R.id.go_btn);

        ArrayAdapter<String> adapter = new Adptr(this, android.R.layout.simple_list_item_1, tvText);
        destino.setAdapter(adapter);
        destino.setThreshold(1);
        origem.setAdapter(adapter);
        origem.setThreshold(1);

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

        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Selection.this, Compass.class);
                Global global = (Global)getApplicationContext();
                Map map = global.getMap();
                EdgeWeightedDigraph graph = global.getGraph();
                System.out.println(origem.getText().toString());
                System.out.println(destino.getText().toString());
                global.setDirection(map.direcoes(origem.getText().toString(), destino.getText().toString(),graph, map));
                intent.putExtra("destino",destino.getText().toString());
                startActivity(intent);
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
                origem.setText(result.getContents());
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
