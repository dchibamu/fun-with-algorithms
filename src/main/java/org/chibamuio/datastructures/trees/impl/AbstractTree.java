package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.trees.Tree;
import org.chibamuio.datastructures.core.Position;

import java.util.Stack;

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

    @Override
    public int depth(final Position<E> p) {
        Position<E> pos = null;
        int depth = 0;
        if(isRoot(p))
            return 0;
        else
            do {
                depth++;
                pos = parent(p);
            }while(pos != p);
        return depth;
    }

    public int height(Position<E> p){

        int h = 0;
        for(Position<E> position : children(p)){
            h = Math.max(h, 1 + height(position));
        }
        return h;
    }


}
