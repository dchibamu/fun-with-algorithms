package org.chibamuio.datastructures.graphs;
import org.chibamuio.datastructures.graphs.impl.Edge;

import java.util.Iterator;

public interface Graph {

    /**
     *Returns number of vertices in graph
     * @return The number of vertices
     */
    int getNumV();

    /**
     *Determine whether this is a directed graph.
     * @return true if this is a directed graph
     */
    boolean isDirected();

    /**
     * Inserts a new edge into the graph
     * @param edge
     */
    void insert(Edge edge);

    /**
     *
     * @param source
     * @param dst
     * @return
     */
    boolean isEdge(int source, int dst);

    /**
     *
     * @param source
     * @param dst
     * @return
     */
    Edge getEdge(int source, int dst);

    /**
     *
     * @param source
     * @return
     */
    Iterator<Edge> edgeIterator(int source);
}
