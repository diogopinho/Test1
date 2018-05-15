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

import java.util.ArrayList;
//import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Map map = new Map();
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(26);
        DijkstraSP a = null;
        map.criar_mapa(map,graph);
        String partida = "Sala 111";
        String chegada = "Gabinete 6";
        int id1 = map.get_id_node(partida);
        int id2 = map.get_id_node(chegada);
        a = new DijkstraSP(graph,id1);
        Stack<DirectedEdge> path = (Stack<DirectedEdge>) a.pathTo(id2);
        for (int i =0; i< path.size();i=0){
            System.out.println(path.peek().from());
            int aux = path.peek().from();
            ArrayList<Arc> arc = new ArrayList<>();
            arc = map.findArc(aux);
            /*for (int j=0; j<arc.size();j++){
                arc.get(j).
            }*/
            System.out.println(map.findNodeId(path.pop().from()).isQR());
        }
        System.out.println(a.pathTo(id2)+"\n"+a.pathTodistance(id2));
        //map.melhor_caminho(partida,chegada,map,a,graph);


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
