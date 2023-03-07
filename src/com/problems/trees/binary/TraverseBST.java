package com.problems.trees.binary;

import java.util.ArrayList;
import java.util.List;

public class TraverseBST {
    public static void main(String[] args) {
        BST root = new BST(10, new BST(5, new BST(2, new BST(1), null), new BST(5)), new BST(15, null, new BST(22)));
        System.out.print("Preorder: ");
        for(int e : preOrderTraverse(root, null)) System.out.print(e + " ");
        System.out.println();
        System.out.print("PostOrder: ");
        for(int e : postOrderTraverse(root, null)) System.out.print(e + " ");
        System.out.println();
        System.out.print("InOrder: ");
        for(int e : inOrderTraverse(root, null)) System.out.print(e + " ");
        System.out.println();
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if(array == null) array = new ArrayList<>();
        if(tree != null){
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if(array == null) array = new ArrayList<>();
        if(tree != null){
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if(array == null) array = new ArrayList<>();
        if(tree != null){
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
