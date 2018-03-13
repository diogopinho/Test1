package com.example.diogopinho.test1;

import java.util.ArrayList;

/**
 * Created by João Cardoso on 13/03/2018.
 */

public class Node {

    private String label;
    private int floor;
    private String picture; // name of picture to show
    private ArrayList<Arc> adjacentArcs;

    public Node(String label){
        this.label = label;
        adjacentArcs = new ArrayList<Arc>();
    }

    public void addAdjacent(Arc arc){
        if(this.adjacentArcs.contains(arc)){
            return;
        }
        this.adjacentArcs.add(arc);
    }

    public Arc getAdjacentArc(int index){
        return this.adjacentArcs.get(index);
    }

    public int getAdjacentSize(){
        return this.adjacentArcs.size();
    }

    public boolean isQRNode(){
        return false;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ArrayList<Arc> getAdjacentArcs() {
        return adjacentArcs;
    }

    public void setAdjacentArcs(ArrayList<Arc> adjacentArcs) {
        this.adjacentArcs = adjacentArcs;
    }
}
