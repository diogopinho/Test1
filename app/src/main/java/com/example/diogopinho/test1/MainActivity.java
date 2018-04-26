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
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Map map = new Map();
        Node ponto11 = new Node ("ponto1.1");
        ponto11.setFloor(1);
        ponto11.setQR(true);
        ponto11.setId(1);
        Node sala111 = new Node("Sala 111");
        sala111.setId(2);
        sala111.setFloor(1);
        sala111.setQR(false);
        Arc lig11_111 = new Arc(ponto11,sala111,7);
        ponto11.addAdjacent(lig11_111);
        sala111.addAdjacent(lig11_111);
        map.addNode(ponto11);
        map.addNode(sala111);
        map.addArc(ponto11, sala111, 7);
        Node sala110 = new Node ("Sala 110");
        sala110.setId(3);
        sala110.setFloor(1);
        sala110.setQR(false);
        map.addNode(sala110);
        map.addArc(sala111, sala110,5);
        Node sala109 = new Node ("Sala 109");
        sala109.setId(4);
        sala109.setFloor(1);
        sala109.setQR(false);
        map.addNode(sala109);
        map.addArc(sala110, sala109,8);
        Node sala108 = new Node ("Sala 108");
        sala108.setId(5);
        sala108.setFloor(1);
        sala108.setQR(false);
        map.addNode(sala108);
        map.addArc(sala109, sala108,8);
        Node ponto12 = new Node ("Ponto 1.2");
        ponto12.setId(6);
        ponto12.setFloor(1);
        ponto12.setQR(true);
        map.addNode(ponto12);
        map.addArc(sala108,ponto12,2);
        Node sala107 = new Node ("Sala 107");
        sala107.setId(7);
        sala107.setFloor(1);
        sala107.setQR(false);
        map.addNode(sala107);
        map.addArc(ponto12,sala107,2);
        Node A2 = new Node ("Sala A2");
        A2.setId(8);
        A2.setFloor(1);
        A2.setQR(false);
        map.addNode(A2);
        map.addArc(sala107,A2,2);
        Node sala101 = new Node ("Sala 101");
        sala101.setId(9);
        sala101.setFloor(1);
        sala101.setQR(false);
        map.addNode(sala101);
        map.addArc(A2,sala101,16);
        Node ponto13 = new Node ("Ponto 1.3");
        ponto13.setId(10);
        ponto13.setFloor(1);
        ponto13.setQR(true);
        map.addNode(ponto13);
        map.addArc(sala101,ponto13,2);
        Node sala102 = new Node ("Sala 102");
        sala102.setId(11);
        sala102.setFloor(1);
        sala102.setQR(false);
        map.addNode(sala102);
        map.addArc(ponto13,sala102,5);
        Node sala103 = new Node ("Sala 103");
        sala103.setId(12);
        sala103.setFloor(1);
        sala103.setQR(false);
        map.addNode(sala103);
        map.addArc(sala102,sala103,8);
        Node sala104 = new Node ("Sala 104");
        sala104.setId(13);
        sala104.setFloor(1);
        sala104.setQR(false);
        map.addNode(sala104);
        map.addArc(sala103,sala104,11);
        Node ponto14 = new Node ("Ponto 1.4");
        ponto14.setId(14);
        ponto14.setFloor(1);
        ponto14.setQR(true);
        map.addNode(ponto14);
        map.addArc(sala104,ponto14,4);
        Node sala105 = new Node ("Sala 105");
        sala105.setId(15);
        sala105.setFloor(1);
        sala105.setQR(false);
        map.addNode(sala105);
        map.addArc(ponto14,sala105,3);
        Node sala106 = new Node ("Sala 106");
        sala106.setId(16);
        sala106.setFloor(1);
        sala106.setQR(false);
        map.addNode(sala106);
        map.addArc(sala105,sala106,8);
        Node ponto15 = new Node ("Ponto 1.5");
        ponto15.setId(17);
        ponto15.setFloor(1);
        ponto15.setQR(true);
        map.addNode(ponto15);
        map.addArc(sala106,ponto15,3);
        Node gab1 = new Node ("Gabinete 1");
        gab1.setId(18);
        gab1.setFloor(1);
        gab1.setQR(false);
        map.addNode(gab1);
        map.addArc(ponto15,gab1,9);
        Node gab2 = new Node ("Gabinete 2");
        gab2.setId(19);
        gab2.setFloor(1);
        gab2.setQR(false);
        map.addNode(gab2);
        map.addArc(gab1,gab2,4);
        Node gab3 = new Node ("Gabinete 3");
        gab3.setId(20);
        gab3.setFloor(1);
        gab3.setQR(false);
        map.addNode(gab3);
        map.addArc(gab2,gab3,4);
        Node gab4 = new Node ("Gabinete 4");
        gab4.setId(21);
        gab4.setFloor(1);
        gab4.setQR(false);
        map.addNode(gab4);
        map.addArc(gab3,gab4,4);
        Node gab5 = new Node ("Gabinete 5");
        gab5.setId(22);
        gab5.setFloor(1);
        gab5.setQR(false);
        map.addNode(gab5);
        map.addArc(gab4,gab5,5);
        Node gab6 = new Node ("Gabinete 6");
        gab6.setId(23);
        gab6.setFloor(1);
        gab6.setQR(false);
        map.addNode(gab6);
        map.addArc(gab5,gab6,5);
        Node ponto16 = new Node ("Ponto 1.6");
        ponto16.setId(24);
        ponto16.setFloor(1);
        ponto16.setQR(true);
        map.addNode(ponto16);
        map.addArc(gab6,ponto16,6);


        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(25);
        DirectedEdge d;
        d = new DirectedEdge(1,6, 32);
        graph.addEdge(d);
        d = new DirectedEdge(1,14, 15);
        graph.addEdge(d);
        d = new DirectedEdge(6,10, 46);
        graph.addEdge(d);
        d = new DirectedEdge(6,1, 32);
        graph.addEdge(d);
        d = new DirectedEdge(10,6, 46);
        graph.addEdge(d);
        d = new DirectedEdge(10,14, 26);
        graph.addEdge(d);
        d = new DirectedEdge(14,10, 26);
        graph.addEdge(d);
        d = new DirectedEdge(14,1, 15);
        graph.addEdge(d);
        d = new DirectedEdge(14,17, 12);
        graph.addEdge(d);
        d = new DirectedEdge(17,14, 12);
        graph.addEdge(d);
        d = new DirectedEdge(17,24, 34);
        graph.addEdge(d);
        d = new DirectedEdge(24,17, 34);
        graph.addEdge(d);
        DijkstraSP a = new DijkstraSP(graph,6);
        /*ystem.out.println(a.pathTo(24));*/

        String partida = "Gabinete 1";
        String chegada = "Sala 102";
        //System.out.println(map.findNode(partida));
        ArrayList <Node> Qr_partida  = map.findNextQR(partida);
        //System.out.println(Qr_partida.size());
        ArrayList <Integer> dis_patida = map.findArc(partida);
        ArrayList <Node> Qr_chegada = map.findNextQR(chegada);
        //System.out.println(Qr_chegada.size());
        ArrayList <Integer> dis_chegada = map.findArc(chegada);


        ArrayList <Node> tamanhos = new ArrayList();
        double max=0;
        tamanhos.add(Qr_chegada.get(0));
        tamanhos.add(Qr_chegada.get(0));
        for (int i=0;i<Qr_partida.size();i++){
            for (int j=0;j<Qr_chegada.size();j++){
                a = new DijkstraSP(graph,Qr_partida.get(i).getId());
                System.out.println(Qr_partida.get(i).getLabel());
                System.out.println(Qr_chegada.get(j).getLabel());
                System.out.println(a.pathTodistance(Qr_chegada.get(j).getId())+dis_patida.get(i)+dis_chegada.get(j));
                System.out.println(a.pathTo(Qr_chegada.get(j).getId())+" "+dis_patida.get(i)+" "+dis_chegada.get(j));
                if (a.pathTodistance(Qr_chegada.get(j).getId())+dis_patida.get(i)+dis_chegada.get(j)<max || (i==0 && j==0)){
                    tamanhos.add(0, Qr_partida.get(i));
                    tamanhos.add(1, Qr_chegada.get(j));
                    max = a.pathTodistance(Qr_chegada.get(j).getId())+dis_patida.get(i)+dis_chegada.get(j);
                }
                System.out.println(max);
            }
        }
        System.out.println("O codigo QR de partida é: " + tamanhos.get(0).getLabel());
        System.out.println();
        System.out.println("O codigo QR de chegada é: " + tamanhos.get(1).getLabel());


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
