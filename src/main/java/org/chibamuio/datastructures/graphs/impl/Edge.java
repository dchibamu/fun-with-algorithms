package org.chibamuio.datastructures.graphs.impl;

public class Edge {

    private int source;
    private int dest;
    private double weight;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
