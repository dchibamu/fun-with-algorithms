package org.chibamuio.datastructures.graphs.impl;

import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
    }

    @Override
    public void insert(Edge edge) {

    }

    @Override
    public boolean isEdge(int source, int dst) {
        return false;
    }

    @Override
    public Edge getEdge(int source, int dst) {
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }
}
