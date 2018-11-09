package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.core.Position;
import org.chibamuio.datastructures.trees.Tree;

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
    public Iterable<Position<E>> inOrderPositions(){
        return inOrder();
    }

    @Override
    public Iterable<Position<E>> preOrderPositions() {
        return preOrder();
    }

    @Override
    public Iterable<Position<E>> postOrderPositions() {
        return postOrder();
    }

    public Iterable<Position<E>> inOrder() {

        List<Position<E>> snapShot = new ArrayList<>();
        if(!isEmpty()){
            inOrderSubtree(root(), snapShot);
        }
        return snapShot;
    }

    private void inOrderSubtree(Position<E> p, List<Position<E>> snapShot){

        if(left(p) != null){
            inOrderSubtree(left(p), snapShot);
        }

        snapShot.add(p);

        if(right(p) != null){
            inOrderSubtree(right(p), snapShot);
        }
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

    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapShot = new ArrayList<>();
        if(!isEmpty()){
            postOrderSubtree(root(), snapShot);
        }
        return snapShot;
    }

    private void postOrderSubtree(Position<E> p, List<Position<E>> snapShot){
        for(Position<E> childPosition: children(p))
            postOrderSubtree(childPosition, snapShot);
        snapShot.add(p);
    }

    @Override
    public void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {

        int d = path.size();
        
    }
}
