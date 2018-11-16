package org.chibamuio.datastructures.trees.impl;

import org.chibamuio.datastructures.core.Position;
import org.chibamuio.datastructures.trees.BinaryTree;
import org.chibamuio.datastructures.utils.BinaryTreeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("<=== LinkedBanaryTreeSpecification===>")
public class LinkedBinaryTreeSpecTest<E> {

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
    public void shouldReturnTreePreOrderTraversal(){
        Character[] letters = {'A', 'B', 'C','D','E','F','G'};
        Character[] expectedPreorder = {'A', 'B', 'D', 'E', 'C', 'F', 'G'};

        BinaryTree<Character> binaryTree = BinaryTreeUtils.createBinaryTree(letters);

        Position<Character> root = binaryTree.root();
        assertEquals(root.getElement(), letters[0], () -> "Root element should be A");

        Position<Character> rootLeftChild = binaryTree.left(root);
        Position<Character> rootRightChild = binaryTree.right(root);
        assertEquals(rootLeftChild.getElement(), letters[1], () -> "Left child to A should be B");
        assertEquals(rootRightChild.getElement(), letters[2], () -> "Right child to A should be C");

        Iterable<Position<Character>> positions = binaryTree.preOrderPositions();
        List<Position<Character>> target= new ArrayList<>();
        positions.forEach(target::add);
        Character[] traversalPattern = new Character[target.size()];
        traversalPattern = target.stream().map((p) -> p.getElement()).collect(Collectors.toList()).toArray(traversalPattern);

        assertEquals(expectedPreorder.length, traversalPattern.length);
        assertArrayEquals(expectedPreorder, traversalPattern, () -> "Wrong preorder traversal pattern");
    }

    @Test
    public void shouldReturnTreeInOrderTraversal() {
        Character[] letters = {'A', 'B', 'C','D','E','F','G'};
        Character[] expectedPreorder = {'D', 'B', 'E', 'A', 'F', 'C', 'G'};

        BinaryTree<Character> binaryTree = BinaryTreeUtils.createBinaryTree(letters);

        Iterable<Position<Character>> positions = binaryTree.inOrderPositions();
        List<Position<Character>> target = new ArrayList<>();
        positions.forEach(target::add);
        Character[] traversalPattern = new Character[target.size()];
        traversalPattern = target.stream().map((p) -> p.getElement()).collect(Collectors.toList()).toArray(traversalPattern);

        assertEquals(expectedPreorder.length, traversalPattern.length);
        assertArrayEquals(expectedPreorder, traversalPattern, () -> "Wrong inorder traversal pattern");
    }

    @Test
    public void shouldReturnTreePostOrderTraversal() {
        Character[] letters = {'A', 'B', 'C','D','E','F','G'};
        Character[] expectedPostOrder = {'D', 'E', 'B', 'F', 'G', 'C', 'A'};

        BinaryTree<Character> binaryTree = BinaryTreeUtils.createBinaryTree(letters);

        Iterable<Position<Character>> positions = binaryTree.postOrderPositions();
        List<Position<Character>> target = new ArrayList<>();
        positions.forEach(target::add);
        Character[] traversalPattern = new Character[target.size()];
        traversalPattern = target.stream().map((p) -> p.getElement()).collect(Collectors.toList()).toArray(traversalPattern);

        assertEquals(expectedPostOrder.length, traversalPattern.length);
        assertArrayEquals(expectedPostOrder, traversalPattern, () -> "Wrong post-order traversal pattern");
    }


    @Test
    public void shouldReturnHieghtOfNode() {
       Character[] letters =
               {'B', 'Z', 'X','K','I',null,null,
                       'N', 'J', 'M', null, null, null, null, null, 'B', 'A','C', 'E'};
        BinaryTree<Character> binaryTree = BinaryTreeUtils.createBinaryTree(letters);
        Position<Character> root = binaryTree.root();
        assertEquals(4, binaryTree.height(root));
    }

    @Test
    public void shouldIterativelyCalculateHeight() {
        List<String> wordsTreeData = new ArrayList<>(Collections.nCopies(11, null));
        wordsTreeData.set(0, "A");
        wordsTreeData.set(1, "B");
        wordsTreeData.set(2, "C");
        wordsTreeData.set(3, "K");
        wordsTreeData.set(4, "M");
        wordsTreeData.set(5, null);
        wordsTreeData.set(6, null);
        wordsTreeData.set(7, "Q");
        wordsTreeData.set(8, "P");
        wordsTreeData.set(9, "J");
        wordsTreeData.set(10, "H");

        BinaryTree<String> binaryTree = BinaryTreeUtils.createBinaryTree(wordsTreeData);
        int height = binaryTree.iterativeTreeHeight();
        assertEquals(3, height, () -> "Wrong height of tree");
    }

    @Test
    public void shouldReturnListOfChildren() {
        List<String> wordsTreeData = new ArrayList<>(Collections.nCopies(11, null));
        wordsTreeData.set(0, "A");
        wordsTreeData.set(1, "B");
        wordsTreeData.set(2, "C");
        wordsTreeData.set(3, "K");
        wordsTreeData.set(4, "M");
        wordsTreeData.set(5, null);
        wordsTreeData.set(6, null);
        wordsTreeData.set(7, "Q");
        wordsTreeData.set(8, "P");
        wordsTreeData.set(9, "J");
        wordsTreeData.set(10, "H");
        BinaryTree<String> binaryTree = BinaryTreeUtils.createBinaryTree(wordsTreeData);
        Position<String> root = binaryTree.root();

        Iterable<Position<String>> children = binaryTree.children(root);
        Iterator<Position<String>> iterator = children.iterator();

        Position<String> left = iterator.next();
        Position<String> right = iterator.next();
        assertEquals("B", left.getElement(), () -> "B is not equal to "+left.getElement());
        assertEquals("C", right.getElement(), () -> "C is not equal to "+right.getElement());
    }
}
