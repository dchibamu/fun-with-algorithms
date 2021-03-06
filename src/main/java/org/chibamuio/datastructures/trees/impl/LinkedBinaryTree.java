package org.chibamuio.datastructures.trees.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.chibamuio.datastructures.core.Position;

import java.util.*;
import java.util.stream.StreamSupport;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected Node<E> root = null;
    private int size = 0;

    @Getter
    @Setter
    @AllArgsConstructor
    protected static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<>(e, parent, left, right);
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }


    public Position<E> addRoot(E e) throws IllegalArgumentException{
        if(!isEmpty())
            throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);

        if(parent.getLeft() != null)
            throw new IllegalStateException("Node already has left child");

        Node<E> leftChild = createNode(e, parent, null, null );
        parent.setLeft(leftChild);
        size++;
        return leftChild;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null)
            throw new IllegalStateException("Node already has right child");
        Node<E> rightChild = createNode(e, parent, null, null);
        parent.setRight(rightChild);
        size++;
        return rightChild;
    }

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> parent = node.getParent();
        if(parent.getLeft() == node){
            return parent.getRight();
        }
        if(parent.getRight() == node){
            return parent.getLeft();
        }
        return null;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {

        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid position");
        Node<E> node = (Node<E>) p;
        if (node.getParent() == null && root() != p)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Boolean isBalanced(Position<E> p) throws IllegalArgumentException {
        int leftTreeHeight = 0, rightTreeHeight = 0;
        boolean isLeftBalanced = true;
        boolean isRightBalanced = true;

        if(left(p) != null)
            leftTreeHeight = height(left(p));
        if(right(p) != null)
            rightTreeHeight = height(right(p));

        boolean heightBalanced = Math.abs(leftTreeHeight - rightTreeHeight) <= 1;
        if(left(p) != null)
            isLeftBalanced = isBalanced(left(p));
        if(right(p) != null)
            isRightBalanced = isBalanced(right(p));
        return heightBalanced && isLeftBalanced && isRightBalanced;
    }

    @Override
    public List<E> largestCompleteSubtree(Position<E> parentPersipective) throws IllegalArgumentException {
        List<E> subTree = new ArrayList<>();

        Position<E> currentPerspective = parentPersipective;


        return subTree;
    }
}
