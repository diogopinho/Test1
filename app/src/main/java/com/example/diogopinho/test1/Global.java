package com.example.diogopinho.test1;

import android.app.Application;

public class Global extends Application {

    private Map map;
    private EdgeWeightedDigraph graph;
    Iterable<DirectedEdge> direction;


    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public EdgeWeightedDigraph getGraph() {
        return graph;
    }

    public void setGraph(EdgeWeightedDigraph graph) {
        this.graph = graph;
    }

    public Iterable<DirectedEdge> getDirection() {
        return direction;
    }

    public void setDirection(Iterable<DirectedEdge> direction) {
        this.direction = direction;
    }
}
