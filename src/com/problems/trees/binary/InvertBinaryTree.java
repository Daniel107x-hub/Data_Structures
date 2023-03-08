package com.problems.trees.binary;


public class InvertBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1, new BinaryTree(2, new BinaryTree(4, new BinaryTree(8), new BinaryTree(9)), new BinaryTree(5)), new BinaryTree(3, new BinaryTree(6), new BinaryTree(7)));
        invertBinaryTree(root);
        System.out.println();
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) return;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
