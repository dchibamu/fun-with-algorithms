package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.core.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    public Position<E> sibling(Position<E> p) throws IllegalArgumentException{
        Position<E> parent = parent(p);
        if(parent == null)
            return null;
        if(p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    public int numChildren(Position<E> p)  throws IllegalArgumentException {
        int count = 0;
        if(left(p) != null)
            count++;
        if(right(p) != null)
            count++;
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p) != null)
            snapshot.add(left(p));
        if(right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }
    @Override
    public Iterable<Position<E>> positions(){
        return preOrder();
    }

    public Iterable<Position<E>> preOrder() {
        List<Position<E>> snapShot = new ArrayList<>();
        if(!isEmpty())
            preOrderSubtree(root(), snapShot);
        return snapShot;
    }

    private void preOrderSubtree(Position<E> position, List<Position<E>> snapShot){
        snapShot.add(position);
        for(Position<E> childPosition: children(position))
            preOrderSubtree(childPosition, snapShot);
    }
}
