package org.chibamuio.datastructures.list.impl;

import lombok.*;
import org.chibamuio.datastructures.list.Position;
import org.chibamuio.datastructures.list.PositionalList;


@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LinkedPositionalList<E> implements PositionalList<E> {

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        this.header = new Node<E> (null, null, null);
        this.trailer = new Node<E> (null, header, null);
        header.setNext(trailer);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrevious());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        return position(validate(p).getPrevious());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        return position(validate(p).getNext());
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrevious(), trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrevious(), node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        size--;
        E removed = node.getElement();
        node.setPrevious(null);
        node.setNext(null);
        node.setElement(null);

        return removed;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>)p;
        if(node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node){
        if(node == header || node == trailer)
            return null;
        return node;
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
        Node<E> newNode = new Node<>(e, pred, succ);
        pred.setNext(newNode);
        succ.setPrevious(newNode);
        size++;
        return position(newNode);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    private static class Node<E> implements Position<E> {

        private E element;
        private Node<E> previous;
        private Node<E> next;

        @Override
        public E getElement() throws IllegalArgumentException {
            return this.getElement();
        }
    }
}
