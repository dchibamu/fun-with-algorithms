package org.chibamuio.datastructures.utils;

import org.chibamuio.datastructures.core.Position;
import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.trees.impl.LinkedBinaryTree;

public class BinaryTreeUtils<E> {

    public static <E> BinaryTree<E> createBinaryTree(E[] treeValues){
        LinkedBinaryTree<E> binaryTree = new LinkedBinaryTree<>();
        Position<E> root = binaryTree.addRoot(treeValues[0]);
        buildTree(treeValues, binaryTree, root, 0);
        return binaryTree;
    }

    private static <E> void buildTree(E[] treeValues, LinkedBinaryTree<E> binaryTree, Position<E> parent, int i){
        if(2 * i + 1 < treeValues.length){

           Position<E> leftChild = binaryTree.addLeft(parent, treeValues[2 * i + 1]);
            //System.out.println(leftChild.getElement());
            buildTree(treeValues, binaryTree, leftChild, 2 * i + 1);

            Position<E> rightChild = binaryTree.addRight(parent, treeValues[2 * i + 2]);
            buildTree(treeValues, binaryTree, rightChild, 2 * i + 2);
        }
    }
}
