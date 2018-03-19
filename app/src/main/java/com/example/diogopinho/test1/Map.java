package com.example.diogopinho.test1;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by João Cardoso on 13/03/2018.
 */

public class Map {
    private HashMap<String, Node> nodes;
    private HashMap<Integer, Arc> arcs;

    public Map(){
        this.nodes = new HashMap<String, Node>();
        this.arcs = new HashMap<Integer, Arc>();
    }

    public Map(ArrayList<Node> nodes){
        this.nodes = new HashMap<String, Node>();
        this.arcs = new HashMap<Integer, Arc>();
        for(Node n: nodes){
            this.nodes.put(n.getLabel(), n);
        }
    }

    public boolean addArc(Node no1, Node no2, int distance){
        Arc arc = new Arc(no1, no2, distance);
        arcs.put(arc.hashCode(), arc);
        no1.addAdjacent(arc);
        no2.addAdjacent(arc);
        return true;
    }

    public boolean addNode(Node node){
        nodes.put(node.getLabel(), node);
        return true;
    }

    // Exemplo

}

