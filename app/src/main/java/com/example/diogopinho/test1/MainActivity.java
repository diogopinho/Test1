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
        Node ponto11 = new Node ("ponto1.1");
        ponto11.setFloor(1);
        ponto11.setQR(true);
        Node sala111 = new Node("Sala 111");
        sala111.setFloor(1);
        sala111.setQR(false);
        Arc lig11_111 = new Arc(ponto11,sala111,7);
        ponto11.addAdjacent(lig11_111);
        sala111.addAdjacent(lig11_111);
        map.addNode(ponto11);
        map.addNode(sala111);
        map.addArc(ponto11, sala111, 7);
        Node sala110 = new Node ("Sala 110");
        sala110.setFloor(1);
        sala110.setQR(false);
        map.addNode(sala110);
        map.addArc(sala111, sala110,5);
        Node sala109 = new Node ("Sala 109");
        sala109.setFloor(1);
        sala109.setQR(false);
        map.addNode(sala109);
        map.addArc(sala110, sala109,8);
        Node sala108 = new Node ("Sala 108");
        sala108.setFloor(1);
        sala108.setQR(false);
        map.addNode(sala108);
        map.addArc(sala109, sala108,8);
        Node ponto12 = new Node ("Ponto 1.2");
        ponto12.setFloor(1);
        ponto12.setQR(true);
        map.addNode(ponto12);
        map.addArc(sala108,ponto12,2);
        Node sala107 = new Node ("Sala 107");
        sala107.setFloor(1);
        sala107.setQR(false);
        map.addNode(sala107);
        map.addArc(ponto12,sala107,2);


        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(7);
        DirectedEdge d;
        d = new DirectedEdge(1,2, 32);
        graph.addEdge(d);
        d = new DirectedEdge(1,4, 15);
        graph.addEdge(d);
        d = new DirectedEdge(2,3, 46);
        graph.addEdge(d);
        d = new DirectedEdge(2,1, 32);
        graph.addEdge(d);
        d = new DirectedEdge(3,2, 46);
        graph.addEdge(d);
        d = new DirectedEdge(3,4, 26);
        graph.addEdge(d);
        d = new DirectedEdge(3,4, 26);
        graph.addEdge(d);
        d = new DirectedEdge(4,3, 26);
        graph.addEdge(d);
        d = new DirectedEdge(4,1, 15);
        graph.addEdge(d);
        d = new DirectedEdge(4,5, 12);
        graph.addEdge(d);
        d = new DirectedEdge(5,4, 12);
        graph.addEdge(d);
        d = new DirectedEdge(5,6, 34);
        graph.addEdge(d);
        d = new DirectedEdge(6,5, 34);
        graph.addEdge(d);
        DijkstraSP a = new DijkstraSP(graph,2);
        System.out.println(a.pathTo(6));

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
