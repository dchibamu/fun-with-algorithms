package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.core.Position;
import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.utils.BinaryTreeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("<=== LinkedBanaryTreeSpecification===>")
public class LinkedBinaryTreeSpec<E> {

    @Test
    public void treeShouldAgreeWithStructureSpec() {
        Integer[] treeValues = {14, 90, 1, 6, 40, null, null, 2, 37};
        BinaryTree<Integer> binaryTree = BinaryTreeUtils.createBinaryTree(treeValues);
        Position<Integer> root = binaryTree.root();

        assertTrue(root.getElement().compareTo(treeValues[0]) == 0, () -> "Root value should be " + treeValues[0]);
        assertEquals(Integer.valueOf(root.getElement()), treeValues[0], () -> "Root value should be " + treeValues[0]);


        Position<Integer> rootLeftChild = binaryTree.left(root);
        Position<Integer> rootRightChild = binaryTree.right(root);

        assertEquals(Integer.valueOf(rootLeftChild.getElement()), treeValues[1], () -> "Value should be " + treeValues[1]);
        assertEquals(Integer.valueOf(rootRightChild.getElement()), treeValues[2], () -> "Value should be " + treeValues[2]);

        Position<Integer> leftChild90 = binaryTree.left(rootLeftChild);
        Position<Integer> rightChild90 = binaryTree.right(rootLeftChild);
        assertEquals(Integer.valueOf(leftChild90.getElement()), treeValues[3], () -> "Value should be " + treeValues[3]);
        assertEquals(Integer.valueOf(rightChild90.getElement()), treeValues[4], () -> "Value should be " + treeValues[4]);

        Position<Integer> leftChildSix = binaryTree.left(leftChild90);
        Position<Integer> rightChildSix = binaryTree.right(leftChild90);

        assertEquals(Integer.valueOf(leftChildSix.getElement()), treeValues[7], () -> "Value should be " + treeValues[7]);
        assertEquals(Integer.valueOf(rightChildSix.getElement()), treeValues[8], () -> "Value should be " + treeValues[8]);

        Position<Integer> leftChildOne = binaryTree.left(rootRightChild);
        Position<Integer> rightChildOne = binaryTree.right(rootRightChild);

        assertNull(leftChildOne.getElement(), () -> "Value should be null");
        assertNull(rightChildOne.getElement(), () -> "Value should be null");
    }

    @Test
    public void shouldReturnTreeInPreOrderTraversal(){
        Character[] letters = {'A', 'B', 'C','D','E','F','G'};
        Character[] expectedPreorder = {'A', 'B', 'D', 'E', 'C', 'F', 'G'};

        BinaryTree<Character> binaryTree = BinaryTreeUtils.createBinaryTree(letters);

        Position<Character> root = binaryTree.root();
        assertEquals(root.getElement(), letters[0], () -> "Root element should be A");

        Position<Character> rootLeftChild = binaryTree.left(root);
        Position<Character> rootRightChild = binaryTree.right(root);
        assertEquals(rootLeftChild.getElement(), letters[1], () -> "Left child to A should be B");
        assertEquals(rootRightChild.getElement(), letters[2], () -> "Right child to A should be C");

        Iterable<Position<Character>> positions = binaryTree.positions();
        List<Position<Character>> target= new ArrayList<>();
        positions.forEach(target::add);
        Character[] traversalPattern = new Character[target.size()];
        traversalPattern = target.stream().map((p) -> p.getElement()).collect(Collectors.toList()).toArray(traversalPattern);

        assertEquals(expectedPreorder.length, traversalPattern.length);
        assertArrayEquals(expectedPreorder, traversalPattern, () -> "Wrong preorder traversal pattern");
    }

    
}