package org.chibamuio.datastructures.graphs;

import org.chibamuio.datastructures.graphs.impl.Edge;
import org.chibamuio.datastructures.graphs.impl.ListGraph;
import org.junit.jupiter.api.Test;

public class ListGraphTest {

    @Test
    void shouldInsertEdgesIntoGraph(){
        ListGraph listGraph = new ListGraph(10, false);
        Edge edge1 = new Edge(12, 37);
        Edge edge2 = new Edge(12, 2);

        Edge edge3 = new Edge(2, 5);
        Edge edge4 = new Edge(5, 3);
        Edge edge5 = new Edge(3, 25);
        Edge edge6 = new Edge(3, 0);
        Edge edge7 = new Edge(15, 17);
        Edge edge8 = new Edge(15, 37);
        Edge edge9 = new Edge(15, 11);
        Edge edge10 = new Edge(37, 12);
        listGraph.insert(edge1);
        
    }
}
