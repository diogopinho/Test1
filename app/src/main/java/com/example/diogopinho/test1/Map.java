package com.example.diogopinho.test1;

import java.util.ArrayList;
import java.util.HashMap;


public class Map {
    private HashMap<String, Node> nodes;
    private HashMap<Integer, Arc> arcs;

    Map(){
        this.nodes = new HashMap<>();
        this.arcs = new HashMap<>();
    }

    public Map(ArrayList<Node> nodes){
        this.nodes = new HashMap<>();
        this.arcs = new HashMap<>();
        for(Node n: nodes){
            this.nodes.put(n.getLabel(), n);
        }
    }

    boolean addArc(Node no1, Node no2, int distance){
        Arc arc = new Arc(no1, no2, distance);
        arcs.put(arc.hashCode(), arc);
        no1.addAdjacent(arc);
        no2.addAdjacent(arc);
        return true;
    }

    boolean addNode(Node node){
        nodes.put(node.getLabel(), node);
        return true;
    }

}
