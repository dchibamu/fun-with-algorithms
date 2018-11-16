package org.chibamuio.datastructures.utils;

import org.chibamuio.datastructures.core.Position;
import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.trees.impl.LinkedBinaryTree;

import java.util.List;

public class BinaryTreeUtils<E> {

    public static <E> BinaryTree<E> createBinaryTree(E[] treeValues){
        LinkedBinaryTree<E> binaryTree = new LinkedBinaryTree<>();
        Position<E> root = binaryTree.addRoot(treeValues[0]);
        buildTree(treeValues, binaryTree, root, 0);
        return binaryTree;
    }

    public static <E> BinaryTree<E> createBinaryTree(List<E> treeData){

        LinkedBinaryTree<E> binaryTree = new LinkedBinaryTree<>();
        Position<E> root = binaryTree.addRoot(treeData.get(0));
        buildTree(treeData, binaryTree, root, 0);
        return binaryTree;
    }

    private static <E> void buildTree(List<E> treeData, LinkedBinaryTree<E> binaryTree, Position<E> parent, int i){
        int leftPos = 2 * i + 1;
        int rightPos = 2 * i + 2;

        if(leftPos < treeData.size()){
            Position<E> leftChild = binaryTree.addLeft(parent, treeData.get(leftPos));
            buildTree(treeData, binaryTree, leftChild, leftPos);

            Position<E> rightChild = binaryTree.addRight(parent, treeData.get(rightPos));
            buildTree(treeData, binaryTree, rightChild, rightPos);
        }
    }

    private static <E> void buildTree(E[] treeValues, LinkedBinaryTree<E> binaryTree, Position<E> parent, int i){
        if(2 * i + 1 < treeValues.length){

           Position<E> leftChild = binaryTree.addLeft(parent, treeValues[2 * i + 1]);
            buildTree(treeValues, binaryTree, leftChild, 2 * i + 1);

            Position<E> rightChild = binaryTree.addRight(parent, treeValues[2 * i + 2]);
            buildTree(treeValues, binaryTree, rightChild, 2 * i + 2);
        }
    }

    public static List<String> generateTreeData(){


        return null;
    }
}
