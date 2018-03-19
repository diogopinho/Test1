package com.example.diogopinho.test1;

import android.support.annotation.NonNull;

public class Arc implements Comparable<Arc> {
    private Node node1;
    private Node node2;
    private int distance;

    public Arc(Node node1, Node node2,int distance){		// could be Arc(Node node1, Node node2, distance, orientation) ?
        this.setNode1(node1);
        this.setNode2(node2);
        this.setDistance(distance);
    }

    public Node getAdjacent(Node currentNode){
        if(!(currentNode.equals(getNode1()) || currentNode.equals(getNode2()))){
            return null;
        }
        return (currentNode.equals(getNode1())) ? getNode2() : getNode1();
    }
    @Override
    public int compareTo(@NonNull Arc arc) {
        return 0;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
