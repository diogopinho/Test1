package com.example.diogopinho.test1;

/**
 * Created by João Cardoso on 13/03/2018.
 */

public class QRNode extends Node {
    public QRNode(String label) {
        super(label, 1);
    }

    public boolean isQRNode(){
        return true;
    }
}
