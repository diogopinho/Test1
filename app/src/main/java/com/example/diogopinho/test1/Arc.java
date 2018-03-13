package com.example.diogopinho.test1;

import android.support.annotation.NonNull;

/**
 * Created by João Cardoso on 13/03/2018.
 */

public class Arc implements Comparable<Arc> {
    private Node node1, node2;
    private int distance;

    public Arc(Node node1, Node node2,int distance){		// could be Arc(Node node1, Node node2, distance, orientation) ?
        this.node1= node1;
        this.node2=node2;
        this.distance=distance;
    }

    public Node getAdjacent(Node currentNode){
        if(!(currentNode.equals(node1) || currentNode.equals(node2))){
            return null;
        }
        return (currentNode.equals(node1)) ? node2 : node1;
    }
    @Override
    public int compareTo(@NonNull Arc arc) {
        return 0;
    }
}
