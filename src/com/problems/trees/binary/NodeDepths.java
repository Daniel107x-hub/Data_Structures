package com.problems.trees.binary;

public class NodeDepths {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1, new BinaryTree(2, new BinaryTree(4, new BinaryTree(8), new BinaryTree(9)), new BinaryTree(5)), new BinaryTree(3, new BinaryTree(6), new BinaryTree(7)));
        System.out.println(nodeDepths(root));
    }

    public static int nodeDepths(BinaryTree root){
        return nodeDepths(root, 0);
    }

    public static int nodeDepths(BinaryTree root, int depth){
        int left = 0;
        int right = 0;
        if(root.left != null) left = nodeDepths(root.left, depth + 1);
        if(root.right != null) right = nodeDepths(root.right, depth + 1);
        return depth + left + right;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
