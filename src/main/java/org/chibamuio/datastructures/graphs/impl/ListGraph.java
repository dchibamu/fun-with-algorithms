package org.chibamuio.datastructures.graphs.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListGraph extends AbstractGraph {
    /** An array of Lists to contain the edges that
     originate with each vertex.
     */
    private List<Edge>[] edges;

    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];
    }

    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if(!isDirected())
            edges[edge.getDest()].add( new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
    }

    @Override
    public boolean isEdge(int source, int dst) {
        return edges[source].contains(new Edge(source, dst));
    }

    @Override
    public Edge getEdge(int source, int dst) {
        return null;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }


    @Override
    public String toString() {
        return "ListGraph{" +
                "edges=" + Arrays.toString(edges) +
                '}';
    }
}
