package com.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1, null, new Node(2, null, new Node(5, new Node(3, null, new Node(4)), new Node(6))));
        levelOrder(root);
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node current = q.peek();
            System.out.print(current.data + " ");
            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);
            q.remove();
        }
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
