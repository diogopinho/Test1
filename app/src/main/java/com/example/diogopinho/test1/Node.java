package com.example.diogopinho.test1;

import java.util.ArrayList;

public class Node {

    private String label;
    private int floor;
    private String picture; // name of picture to show
    private ArrayList<Arc> adjacentArcs;
    private boolean isQR;

    public Node(String label){
        this.label = label;
        adjacentArcs = new ArrayList<>();
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

    public boolean isQR() {
        return isQR;
    }

    public void setQR(boolean QR) {
        isQR = QR;
    }
}
