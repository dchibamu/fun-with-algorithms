package org.chibamuio.datastructures.trees;

import org.chibamuio.datastructures.core.Position;

import java.util.ArrayList;
import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {

    Position<E> root();
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    int numChildren(Position<E> p)throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    boolean isInternal(Position<E> p)throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
    Iterable<Position<E>> preOrderPositions();
    Iterable<Position<E>> inOrderPositions();
    Iterable<Position<E>> postOrderPositions();
    void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path);
    int height(Position<E> p) throws IllegalArgumentException;
    int depth(Position<E> p) throws IllegalArgumentException;

    int iterativeTreeHeight(Position<E> p);

}
