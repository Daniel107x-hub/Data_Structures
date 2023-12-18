package com.problems.trees.binary;

public class TreeSuccessor {
    public static void main(String[] args) {
        BinaryTree n1 = new BinaryTree(1);
        BinaryTree n2 = new BinaryTree(2);
        BinaryTree n3 = new BinaryTree(3);
        BinaryTree n4 = new BinaryTree(4);
        BinaryTree n5 = new BinaryTree(5);
        BinaryTree n6 = new BinaryTree(6);
        n1.left = n2;
        n1.right = n3;
        n2.parent = n1;
        n3.parent = n1;

        n2.left = n4;
        n2.right = n5;
        n4.parent = n2;
        n5.parent = n2;

        n4.left = n6;
        n6.parent = n4;
        BinaryTree successor = findSuccessor(n1, n1);
        System.out.println(successor != null ? successor.value : "NONE");

    }

    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if(node.right != null) return leftmost(node.right);
        BinaryTree parent = node.parent;
        if(parent == null) return null;
        if(parent.left == node) return parent;
        parent = parent.parent;
        if(parent == null) return null;
        return parent;
    }

    public static BinaryTree leftmost(BinaryTree root){
        if(root.left == null) return root;
        return leftmost(root.left);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }


    }
}
