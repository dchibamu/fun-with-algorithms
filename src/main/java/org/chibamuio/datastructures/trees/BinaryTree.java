package org.chibamuio.datastructures.trees;

import org.chibamuio.datastructures.core.Position;

import java.util.List;

public interface BinaryTree<E> extends Tree<E> {

    Position<E> left(Position<E> p) throws IllegalArgumentException;
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
    Boolean isBalanced(Position<E> p) throws IllegalArgumentException;
    List<E> largestCompleteSubtree(Position<E> p) throws IllegalArgumentException;
}
