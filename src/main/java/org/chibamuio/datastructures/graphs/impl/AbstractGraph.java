package org.chibamuio.datastructures.graphs.impl;

import org.chibamuio.datastructures.graphs.Graph;

import java.util.Scanner;

public abstract class AbstractGraph implements Graph {

    /** The number of vertices */
    private int numV;
    /** Flag to indicate whether this is a directed graph*/
    private boolean directed;

    /**
     * Construct a graph with the specified number of vertices and the directed flag.
     * Graph is directed if the directed flag is true
     * @param numV
     * @param directed
     */
    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    @Override
    public int getNumV() {
        return numV;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    /**
     * Load the edges of a graph from the data in an input file. The file
     should contain a series of lines, each line with two or
     three data values. The first is the source, the second is
     the destination, and the optional third is the weight.
     @param scanner The Scanner connected to the data file
     */
    public void loadEdgesFromFile(Scanner scanner){

    }

    /** Factory method to create a graph and load the data from an input
     file. The first line of the input file should contain the number
     of vertices. The remaining lines should contain the edge data as
     described under loadEdgesFromFile.
     @param scan The Scanner connected to the data file
     @param isDirected true if this is a directed graph,
     false otherwise
     @param type The string "Matrix" if an adjacency matrix is to be
     created, and the string "List" if an adjacency list
     is to be created
     @throws IllegalArgumentException if type is neither "Matrix"
     nor "List"
     */
    public static Graph createGraph(Scanner scan, boolean isDirected,
                                    String type) {
        int numV = scan.nextInt();
        AbstractGraph returnValue;
        type = type.toLowerCase();
        switch (type) {
            case "matrix":
                returnValue = new MatrixGraph(numV, isDirected);
                break;
            case "list":
                returnValue = new ListGraph(numV, isDirected);
                break;
            default:
                throw new IllegalArgumentException();
        }
        returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }
}
