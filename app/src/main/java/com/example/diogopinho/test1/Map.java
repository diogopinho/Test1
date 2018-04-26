package com.example.diogopinho.test1;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private HashMap<Integer, Node> nodes;
    private HashMap<Integer, Arc> arcs;

    Map(){
        this.nodes = new HashMap<>();
        this.arcs = new HashMap<>();
    }

    public Map(ArrayList<Node> nodes){
        this.nodes = new HashMap<>();
        this.arcs = new HashMap<>();
        for(Node n: nodes){
            this.nodes.put(n.getId(), n);
        }
    }

    boolean addArc(Node no1, Node no2, int distance){
        Arc arc = new Arc(no1, no2, distance);
        arcs.put(arcs.size()+1, arc);
        no1.addAdjacent(arc);
        no2.addAdjacent(arc);
        return true;
    }

    void addNode(Node node){
        nodes.put(node.getId(), node);
    }

    public int findNode (String nome){
        for (int i=1; i<nodes.size();i++){
            if (nodes.get(i).getLabel()==nome){
                return i;
            }
        }
        return 0;
    }

    public ArrayList<Integer> findArc (String nome){
        ArrayList <Node> a = findNextQR(nome);
        ArrayList <Integer> b = new ArrayList();
        int soma = 0;
        int z=0;
        for (int i=1; i<=arcs.size();i++){
            //System.out.println(arcs.get(i).getNode2().getLabel());
            if (arcs.get(i).getNode1().getLabel()==nome){
                z=1;
            }
            if (z==1 && arcs.get(i).getNode2().getId()!=a.get(0).getId()) {
                soma = soma + arcs.get(i).getDistance();
            }
            else if (z==1 && arcs.get(i).getNode2().getId()==a.get(0).getId()){
                soma = soma + arcs.get(i).getDistance();
                z=0;
                System.out.println(arcs.get(i).getNode2().getLabel() + " " +soma);
                i=arcs.size();
                b.add(soma);
                soma =0;
            }
        }
        for (int i=arcs.size(); i>0;i--){
            System.out.println(arcs.get(i).getNode1().getLabel());
            if (arcs.get(i).getNode2().getLabel().equals(nome)){
                z=1;
                System.out.println("entrei");
            }
            if (z==1 && arcs.get(i).getNode1().getId()!=a.get(1).getId()) {
                System.out.println("entrei2");
                soma = soma + arcs.get(i).getDistance();
            }
            else if (z==1 && arcs.get(i).getNode1().getId()==a.get(1).getId()){
                System.out.println("entrei3");
                soma = soma + arcs.get(i).getDistance();
                z=0;
                //System.out.println(arcs.get(i).getNode1().getLabel()+" " + soma);
                i=0;
                b.add(soma);
                soma =0;
            }
            System.out.println("entrei4");
        }
        return b;
    }

    public ArrayList findNextQR (String nome){
        int i = findNode(nome);
        ArrayList <Node> a = new ArrayList();
        //System.out.println(nodes.size());
        for (int z = i; z <= nodes.size();z++){
            //System.out.println("entrei");
            if (nodes.get(z).isQR()==true){
                //System.out.println("entrei1");
                a.add(nodes.get(z));
                z= nodes.size()+1;
            }
        }
        for (int z = i; z >= 1;z--) {
            if (nodes.get(z).isQR() == true) {
                //System.out.println("entrei2");
                a.add(nodes.get(z));
                z = 0;
            }
        }
        //System.out.println(a);
        return a;
    }


}

