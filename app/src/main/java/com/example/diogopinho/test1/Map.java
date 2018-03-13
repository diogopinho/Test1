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
    Map map = new Map();

    Node sala101 = new Node("Sala 101");
	sala101.setFloor(1);
    Node sala102 = new Node("Sala 102");
	sala102.setFloor(1);
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
}
