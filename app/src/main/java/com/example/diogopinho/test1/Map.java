package com.example.diogopinho.test1;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Map {
    private HashMap<Integer, Node> nodes;
    private HashMap<Integer, Arc> arcs;
    private HashMap<String, Prof> professores;

    @SuppressLint("UseSparseArrays")
    Map(){
        this.nodes = new HashMap<>();
        this.arcs = new HashMap<>();
        this.professores = new HashMap<>();
    }

    /*public Map(ArrayList<Node> nodes){
        this.nodes = new HashMap<>();
        this.arcs = new HashMap<>();
        for(Node n: nodes){
            this.nodes.put(n.getId(), n);
        }
    }*/
    public Node findNodeId(int id){
        for (int i=1; i<=nodes.size();i++){
            if (nodes.get(i).getId()==id){
                return nodes.get(i);
            }
        }
        return null;
    }

    private void addArc(Node no1, Node no2, int distance, int orientacion){
        Arc arc = new Arc(no1, no2, distance, orientacion);
        arcs.put(arcs.size()+1, arc);
        no1.addAdjacent(arc);
        no2.addAdjacent(arc);
    }

    private void addNode(Node node){
        nodes.put(node.getId(), node);
    }

    private void addProf(Prof prof){
        professores.put(prof.getNome(), prof);
    }

    Prof getProf(String nome){
        return professores.get(nome);
    }

    /*private int findNode(String nome){
        for (int i=1; i<nodes.size();i++){
            if (nodes.get(i).getLabel().equals(nome)){
                return i;
            }
        }
        return 0;
    }*/

    ArrayList<Arc> findArc(int id, int id2) {
        ArrayList <Arc> b = new ArrayList <>();
        for (int i=1; i<=arcs.size();i++){
            if (arcs.get(i).getNode1().getId()==id){
                if (arcs.get(i).getNode2().getId()==id2) {
                    b.add(arcs.get(i));
                }
            } else if (arcs.get(i).getNode2().getId()==id){
                if (arcs.get(i).getNode1().getId()==id2) {
                    b.add(arcs.get(i));
                }
            }
        }
        return b;
    }


    /*private ArrayList<Integer> findArc(String nome){
        ArrayList <Node> a = findNextQR(nome);
        ArrayList <Integer> b = new ArrayList <>();
        int soma = 0;
        int z=0;
        for (int i=1; i<=arcs.size();i++){
            //System.out.println(arcs.get(i).getNode2().getLabel());
            if (arcs.get(i).getNode1().getLabel().equals(nome)){
                z=1;
            }
            if (z==1 && arcs.get(i).getNode2().getId()!=a.get(0).getId()) {
                soma = soma + arcs.get(i).getDistance();
            }
            else if (z==1 && arcs.get(i).getNode2().getId()==a.get(0).getId()){
                soma = soma + arcs.get(i).getDistance();
                z=0;
                //System.out.println(arcs.get(i).getNode2().getLabel() + " " +soma);
                i=arcs.size();
                b.add(soma);
                soma =0;
            }
        }
        for (int i=arcs.size(); i>0;i--){
            //System.out.println(arcs.get(i).getNode1().getLabel());
            if (arcs.get(i).getNode2().getLabel().equals(nome)){
                z=1;
                //System.out.println("entrei");
            }
            if (z==1 && arcs.get(i).getNode1().getId()!=a.get(1).getId()) {
                //System.out.println("entrei2");
                soma = soma + arcs.get(i).getDistance();
            }
            else if (z==1 && arcs.get(i).getNode1().getId()==a.get(1).getId()){
                //System.out.println("entrei3");
                soma = soma + arcs.get(i).getDistance();
                z=0;
                //System.out.println(arcs.get(i).getNode1().getLabel()+" " + soma);
                i=0;
                b.add(soma);
                soma =0;
            }
            //System.out.println("entrei4");
        }
        return b;
    }*/

    /*private ArrayList <Node> findNextQR(String nome){
        int i = findNode(nome);
        ArrayList <Node> a = new ArrayList <>();
        //System.out.println(nodes.size());
        for (int z = i; z <= nodes.size();z++){
            //System.out.println("entrei");
            if (nodes.get(z).isQR()){
                //System.out.println("entrei1");
                a.add(nodes.get(z));
                z= nodes.size()+1;
            }
        }
        for (int z = i; z >= 1;z--) {
            if (nodes.get(z).isQR()) {
                //System.out.println("entrei2");
                a.add(nodes.get(z));
                z = 0;
            }
        }
        //System.out.println(a);
        return a;
    }*/

    private int get_id_node(String node){
        for (int i=1; i<=nodes.size();i++){
            if (nodes.get(i).getLabel().equals(node)){
                return i;
            }
        }
        return 0;
    }

    /*void melhor_caminho (String partida, String chegada, Map map, DijkstraSP a, EdgeWeightedDigraph graph) {
        //System.out.println(map.findNode(partida));
        ArrayList <Node> Qr_partida  = map.findNextQR(partida);
        //System.out.println(Qr_partida.size());
        ArrayList <Integer> dis_patida = map.findArc(partida);
        ArrayList <Node> Qr_chegada = map.findNextQR(chegada);
        //System.out.println(Qr_chegada.size());
        ArrayList <Integer> dis_chegada = map.findArc(chegada);
        if (verifica_QR(Qr_partida,Qr_chegada)==0) {
            map.caminho_curto_diferente(Qr_partida, Qr_chegada, dis_patida, dis_chegada, a, graph);
        } else if (verifica_QR(Qr_partida,Qr_chegada)==1){
            System.out.println("A Origem o destino são iguais porem em linhas diferentes");
            caminho_curto_diferente(Qr_partida, Qr_chegada, dis_patida, dis_chegada, a, graph);
        } else {
            System.out.println("Mesma Linha");
        }

    }*/

    /*void caminho_curto_diferente (ArrayList <Node> Qr_partida, ArrayList <Node> Qr_chegada,ArrayList <Integer> dis_patida,ArrayList <Integer> dis_chegada,DijkstraSP a, EdgeWeightedDigraph graph) {

        ArrayList<Node> tamanhos = new ArrayList<>();
        double max = 0;
        tamanhos.add(Qr_chegada.get(0));
        tamanhos.add(Qr_chegada.get(0));
        for (int i = 0; i < Qr_partida.size(); i++) {
            for (int j = 0; j < Qr_chegada.size(); j++) {
                a = new DijkstraSP(graph, Qr_partida.get(i).getId());
                System.out.println(Qr_partida.get(i).getLabel());
                System.out.println(Qr_chegada.get(j).getLabel());
                System.out.println(a.pathTodistance(Qr_chegada.get(j).getId()) + dis_patida.get(i) + dis_chegada.get(j));
                System.out.println(a.pathTo(Qr_chegada.get(j).getId()) + " " + dis_patida.get(i) + " " + dis_chegada.get(j));
                if (a.pathTodistance(Qr_chegada.get(j).getId()) + dis_patida.get(i) + dis_chegada.get(j) < max || (i == 0 && j == 0)) {
                    tamanhos.add(0, Qr_partida.get(i));
                    tamanhos.add(1, Qr_chegada.get(j));
                    max = a.pathTodistance(Qr_chegada.get(j).getId()) + dis_patida.get(i) + dis_chegada.get(j);
                }
                System.out.println(max);
            }
        }
        System.out.println("O codigo QR de partida é: " + tamanhos.get(0).getLabel());
        System.out.println();
        System.out.println("O codigo QR de chegada é: " + tamanhos.get(1).getLabel());
    }*/



    /*int verifica_QR (ArrayList <Node> Qr_partida, ArrayList <Node> Qr_chegada){
        int count=0;
       for (int i=0;i<Qr_partida.size();i++){
           for (int j=0;j<Qr_chegada.size();j++){
               if (Qr_partida.get(i).getLabel().equals(Qr_chegada.get(j).getLabel())){
                   count++;
               }
           }
       }
       return count;
    }*/

    void criar_mapa (Map map, EdgeWeightedDigraph graph){
        DirectedEdge d;
        d = new DirectedEdge(1,14, 15);
        graph.addEdge(d);
        d = new DirectedEdge(14,1, 15);
        graph.addEdge(d);
        Node ponto11 = new Node ("Ponto 1.1");
        ponto11.setFloor(1);
        ponto11.setQR(true);
        ponto11.setId(1);
        Node sala111 = new Node("Sala 111");
        sala111.setId(2);
        sala111.setFloor(1);
        sala111.setQR(false);
        Arc lig11_111 = new Arc(ponto11,sala111,7,180);
        ponto11.addAdjacent(lig11_111);
        sala111.addAdjacent(lig11_111);
        map.addNode(ponto11);
        map.addNode(sala111);
        map.addArc(ponto11, sala111, 7,180);
        d = new DirectedEdge(1,2, 7);
        graph.addEdge(d);
        d = new DirectedEdge(2,1, 7);
        graph.addEdge(d);
        Node sala110 = new Node ("Sala 110");
        sala110.setId(3);
        sala110.setFloor(1);
        sala110.setQR(false);
        map.addNode(sala110);
        map.addArc(sala111, sala110,5,180);
        d = new DirectedEdge(2,3, 5);
        graph.addEdge(d);
        d = new DirectedEdge(3,2, 5);
        graph.addEdge(d);
        Node sala109 = new Node ("Sala 109");
        sala109.setId(4);
        sala109.setFloor(1);
        sala109.setQR(false);
        map.addNode(sala109);
        map.addArc(sala110, sala109,8,180);
        d = new DirectedEdge(3,4, 8);
        graph.addEdge(d);
        d = new DirectedEdge(4,3, 8);
        graph.addEdge(d);
        Node sala108 = new Node ("Sala 108");
        sala108.setId(5);
        sala108.setFloor(1);
        sala108.setQR(false);
        map.addNode(sala108);
        map.addArc(sala109, sala108,8,180);
        d = new DirectedEdge(4,5, 8);
        graph.addEdge(d);
        d = new DirectedEdge(5,4, 8);
        graph.addEdge(d);
        Node ponto12 = new Node ("Ponto 1.2");
        ponto12.setId(6);
        ponto12.setFloor(1);
        ponto12.setQR(true);
        map.addNode(ponto12);
        map.addArc(sala108,ponto12,2,180);
        d = new DirectedEdge(5,6, 2);
        graph.addEdge(d);
        d = new DirectedEdge(6,5, 2);
        graph.addEdge(d);
        Node sala107 = new Node ("Sala 107");
        sala107.setId(7);
        sala107.setFloor(1);
        sala107.setQR(false);
        map.addNode(sala107);
        map.addArc(ponto12,sala107,2,180);
        d = new DirectedEdge(6,7, 2);
        graph.addEdge(d);
        d = new DirectedEdge(7,6, 2);
        graph.addEdge(d);
        Node A2 = new Node ("Sala A2");
        A2.setId(8);
        A2.setFloor(1);
        A2.setQR(false);
        map.addNode(A2);
        map.addArc(sala107,A2,10,90);
        d = new DirectedEdge(7,8, 2);
        graph.addEdge(d);
        d = new DirectedEdge(8,7, 2);
        graph.addEdge(d);
        Node sala101 = new Node ("Sala 101");
        sala101.setId(9);
        sala101.setFloor(1);
        sala101.setQR(false);
        map.addNode(sala101);
        map.addArc(A2,sala101,10,90);
        d = new DirectedEdge(8,9, 16);
        graph.addEdge(d);
        d = new DirectedEdge(9,8, 16);
        graph.addEdge(d);
        Node ponto13 = new Node ("Ponto 1.3");
        ponto13.setId(10);
        ponto13.setFloor(1);
        ponto13.setQR(true);
        map.addNode(ponto13);
        map.addArc(ponto12,ponto13,22,90);
        d = new DirectedEdge(6,10, 20);
        graph.addEdge(d);
        d = new DirectedEdge(10,6, 20);
        graph.addEdge(d);
        map.addArc(sala101,ponto13,2,0);
        d = new DirectedEdge(9,10, 2);
        graph.addEdge(d);
        d = new DirectedEdge(10,9, 2);
        graph.addEdge(d);
        Node sala102 = new Node ("Sala 102");
        sala102.setId(11);
        sala102.setFloor(1);
        sala102.setQR(false);
        map.addNode(sala102);
        map.addArc(ponto13,sala102,5,0);
        d = new DirectedEdge(10,11, 5);
        graph.addEdge(d);
        d = new DirectedEdge(11,10, 5);
        graph.addEdge(d);
        Node sala103 = new Node ("Sala 103");
        sala103.setId(12);
        sala103.setFloor(1);
        sala103.setQR(false);
        map.addNode(sala103);
        map.addArc(sala102,sala103,8,0);
        d = new DirectedEdge(11,12, 8);
        graph.addEdge(d);
        d = new DirectedEdge(12,11, 8);
        graph.addEdge(d);
        Node sala104 = new Node ("Sala 104");
        sala104.setId(13);
        sala104.setFloor(1);
        sala104.setQR(false);
        map.addNode(sala104);
        map.addArc(sala103,sala104,11,0);
        d = new DirectedEdge(12,13, 11);
        graph.addEdge(d);
        d = new DirectedEdge(13,12, 11);
        graph.addEdge(d);
        Node ponto14 = new Node ("Ponto 1.4");
        ponto14.setId(14);
        ponto14.setFloor(1);
        ponto14.setQR(true);
        map.addNode(ponto14);
        map.addArc(sala104,ponto14,4,0);
        d = new DirectedEdge(13,14, 4);
        graph.addEdge(d);
        d = new DirectedEdge(14,13, 4);
        graph.addEdge(d);
        Node sala105 = new Node ("Sala 105");
        sala105.setId(15);
        sala105.setFloor(1);
        sala105.setQR(false);
        map.addNode(sala105);
        map.addArc(ponto14,sala105,3,0);
        d = new DirectedEdge(14,15, 3);
        graph.addEdge(d);
        d = new DirectedEdge(15,14, 3);
        graph.addEdge(d);
        Node sala106 = new Node ("Sala 106");
        sala106.setId(16);
        sala106.setFloor(1);
        sala106.setQR(false);
        map.addNode(sala106);
        map.addArc(sala105,sala106,8,330);
        d = new DirectedEdge(15,16, 8);
        graph.addEdge(d);
        d = new DirectedEdge(16,15, 8);
        graph.addEdge(d);
        Node ponto15 = new Node ("Ponto 1.5");
        ponto15.setId(17);
        ponto15.setFloor(1);
        ponto15.setQR(true);
        map.addNode(ponto15);
        map.addArc(sala106,ponto15,3,330);
        d = new DirectedEdge(16,17, 3);
        graph.addEdge(d);
        d = new DirectedEdge(17,16, 3);
        graph.addEdge(d);
        Node gab1 = new Node ("Gabinete 1");
        gab1.setId(18);
        gab1.setFloor(1);
        gab1.setQR(false);
        map.addNode(gab1);
        map.addArc(ponto15,gab1,9,80);
        d = new DirectedEdge(17,18, 9);
        graph.addEdge(d);
        d = new DirectedEdge(18,17, 9);
        graph.addEdge(d);
        Node gab2 = new Node ("Gabinete 2");
        gab2.setId(19);
        gab2.setFloor(1);
        gab2.setQR(false);
        map.addNode(gab2);
        map.addArc(gab1,gab2,4,80);
        d = new DirectedEdge(18,19, 4);
        graph.addEdge(d);
        d = new DirectedEdge(19,18, 4);
        graph.addEdge(d);
        Node gab3 = new Node ("Gabinete 3");
        gab3.setId(20);
        gab3.setFloor(1);
        gab3.setQR(false);
        map.addNode(gab3);
        map.addArc(gab2,gab3,4,80);
        d = new DirectedEdge(19,20, 4);
        graph.addEdge(d);
        d = new DirectedEdge(20,19, 4);
        graph.addEdge(d);
        Node gab4 = new Node ("Gabinete 4");
        gab4.setId(21);
        gab4.setFloor(1);
        gab4.setQR(false);
        map.addNode(gab4);
        map.addArc(gab3,gab4,4,80);
        d = new DirectedEdge(20,21, 4);
        graph.addEdge(d);
        d = new DirectedEdge(21,20, 4);
        graph.addEdge(d);
        Node gab5 = new Node ("Gabinete 5");
        gab5.setId(22);
        gab5.setFloor(1);
        gab5.setQR(false);
        map.addNode(gab5);
        map.addArc(gab4,gab5,5,80);
        d = new DirectedEdge(21,22, 5);
        graph.addEdge(d);
        d = new DirectedEdge(22,21, 5);
        graph.addEdge(d);
        Node gab6 = new Node ("Gabinete 6");
        gab6.setId(23);
        gab6.setFloor(1);
        gab6.setQR(false);
        map.addNode(gab6);
        map.addArc(gab5,gab6,5,80);
        d = new DirectedEdge(22,23, 5);
        graph.addEdge(d);
        d = new DirectedEdge(23,22, 5);
        graph.addEdge(d);
        Node ponto16 = new Node ("Ponto 1.6");
        ponto16.setId(24);
        ponto16.setFloor(1);
        ponto16.setQR(true);
        map.addNode(ponto16);
        map.addArc(gab6,ponto16,6,80);
        d = new DirectedEdge(23,24, 6);
        graph.addEdge(d);
        d = new DirectedEdge(24,23, 6);
        graph.addEdge(d);
        map.addArc(ponto11, ponto14, 15,90);
        Node ponto21 = new Node ("Ponto 2.1");
        ponto21.setId(25);
        ponto21.setFloor(2);
        ponto21.setQR(true);
        map.addNode(ponto21);
        map.addArc(ponto15,ponto21,13,220);
        d = new DirectedEdge(25,17, 13);
        graph.addEdge(d);
        d = new DirectedEdge(17,25, 13);
        graph.addEdge(d);


        Date d1 = new Date(0,0,0,14,00);
        Date d2 = new Date(0,0,0,15,00);
        Prof p = new Prof("Feliz Gouveia", "Gabinete 6");
        Prof p2 = new Prof("Feliz2 Gouveia", "Gabinete 6");
        p2.add_tempo("Segunda-Feira",d1,d2);
        p.add_tempo("Segunda-Feira",d1,d2);
        p.add_tempo("Sexta-Feira",d1,d2);
        map.addProf(p);
    }

    Iterable<DirectedEdge> direcoes (String partida, String chegada,EdgeWeightedDigraph graph, Map map){
        int id1 = map.get_id_node(partida);
        int id2 = map.get_id_node(chegada);
        System.out.println(id2);
        DijkstraSP a = new DijkstraSP(graph,id1);
        Stack<DirectedEdge> path = (Stack<DirectedEdge>) a.pathTo(id2);
        for (int i =0; i<= path.size();i=1){
            //System.out.println(path.peek().from());
            int aux = path.peek().from();
            ArrayList<Arc> arc = new ArrayList<>();
            if ((map.findNodeId(path.peek().from()).isQR()) || i == 0 || path.size()==1) {
                arc = map.findArc(aux, path.peek().to());
                for (int j = 0; j < arc.size(); j++) {
                    //System.out.println("IS QR");
                    if (i==0){
                        System.out.println("The Frist");
                    } else if (path.size()==1){
                        System.out.println("The Last");
                    } else{
                        System.out.println("IS QR");
                    }
                    if (arc.get(j).getNode1().getId()==aux) {
                        System.out.println(arc.get(j).getNode1().getId() + " - > " + arc.get(j).getNode2().getId() + " = " + arc.get(j).getOrientacion());
                    }
                    else{
                        System.out.print(arc.get(j).getNode2().getId() + " - > " + arc.get(j).getNode1().getId());
                        if (arc.get(j).getOrientacion()>=180){
                            System.out.println(" = " + (arc.get(j).getOrientacion()-180));
                        }else{
                            System.out.println(" = " + (arc.get(j).getOrientacion()+180));
                        }
                    }
                }
            }
            path.pop();
            //System.out.println(map.findNodeId(path.pop().from()).isQR());
        }
        System.out.println(a.pathTo(id2)+"\n"+a.pathTodistance(id2));
        return a.pathTo(id2);
        //map.melhor_caminho(partida,chegada,map,a,graph);
    }
}



