package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.trees.Tree;
import org.chibamuio.datastructures.core.Position;

public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depthRecursive(final Position<E> p){
        if(isRoot(p))
            return 0;
        else
            return 1 + depthRecursive(parent(p));

    }

    public int depthIterative(final Position<E> p) {
        Position<E> pos = null;
        int height = 0;
        if(isRoot(p))
            return 0;
        else
            do {
                height++;
                pos = parent(p);
            }while(pos != root());
        return height;
    }

    public int height(Position<E> p){

        int h = 0;
        for(Position<E> position : children(p)){
            h = Math.max(h, 1 + height(position));
        }
        return h;
    }
}