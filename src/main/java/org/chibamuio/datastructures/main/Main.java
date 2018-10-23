package org.chibamuio.datastructures.main;

import org.chibamuio.datastructures.core.Position;
import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.trees.impl.LinkedBinaryTree;
import org.chibamuio.datastructures.utils.BinaryTreeUtils;

public class Main {

    public static void main(String[] args) {

        Integer[] treeValues = {14, 90, 1, 6, 40, null, null, 2, 37};

        BinaryTree<Integer> binaryTree = BinaryTreeUtils.createBinaryTree(treeValues);
    }

    private static <E>  void printTree(BinaryTree<E> binaryTree ){

        String treeStr = printTreeNode(binaryTree.root(), binaryTree);
        System.out.println(treeStr);
    }

    private static <E> String printTreeNode(Position<E> node, BinaryTree<E> binaryTree){
        String tree = "";

        return (node.getElement() + " "
                    +printTreeNode(binaryTree.left(node), binaryTree) +
                " "+printTreeNode(binaryTree.right(node), binaryTree));
    }
    
}
