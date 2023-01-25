package com.problems.trees;

public class TreeHeight {
    public static void main(String[] args) {
        Node root = new Node(3, new Node(2, new Node(1), null), new Node(5, new Node(4), new Node(6, null, new Node(7))));
        System.out.println(height(root));
    }

    public static int height(Node root){
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
