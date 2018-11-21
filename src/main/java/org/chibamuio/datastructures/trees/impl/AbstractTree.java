package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.trees.Tree;
import org.chibamuio.datastructures.core.Position;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Stack;
import java.util.stream.StreamSupport;

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

    @Override
    public int iterativeTreeHeight(Position<E> p){
        int height = 0;
        int leafNodeHeight = 0;
        Stack<Position> workingStack = new Stack<>();
        workingStack.push(p);
        while(!workingStack.empty()){
            Position<E> currentParent = workingStack.pop();
            Iterator<Position<E>> children = StreamSupport.stream(children(currentParent).spliterator(), false).iterator();
            if(!children.hasNext()) {
                leafNodeHeight = 0;
                Position<E> parentTrace = currentParent;
                while(parentTrace != p){
                    leafNodeHeight++;
                    parentTrace = parent(parentTrace);
                }
                if(leafNodeHeight > height)
                    height = leafNodeHeight;
            }else {
                StreamSupport.stream(Spliterators.spliteratorUnknownSize(children, Spliterator.ORDERED), false)
                        .forEach(workingStack::push);
            }
        }
        return height;
    }


}
