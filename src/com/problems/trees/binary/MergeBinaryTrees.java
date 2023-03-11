package com.problems.trees.binary;

import java.util.Stack;

public class MergeBinaryTrees {
    public static void main(String[] args){
        BinaryTree tree1 = new BinaryTree(1, new BinaryTree(3, new BinaryTree(7), new BinaryTree(4)), new BinaryTree(2));
        BinaryTree tree2 = new BinaryTree(1, new BinaryTree(5, new BinaryTree(2), null), new BinaryTree(9,new BinaryTree(7), new BinaryTree(6)));
        tree1 = mergeBinaryTree(tree1, tree2);
        System.out.println();
    }

    public static BinaryTree mergeBinaryTree(BinaryTree tree1, BinaryTree tree2){
        if(tree1 == null & tree2 == null) return null;
        if(tree1 == null) return tree2;
        if(tree2 == null) return tree1;
        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();
        s1.push(tree1);
        s2.push(tree2);
        while(!s1.isEmpty() && !s2.isEmpty()){
            BinaryTree node1 = s1.pop();
            BinaryTree node2 = s2.pop();
            node1.value += node2.value;
            if(node1.left != null && node2.left != null){
                s1.push(node1.left);
                s2.push(node2.left);
            } else node1.left = node1.left != null ? node1.left : node2.left;
            if (node1.right != null && node2.right != null) {
                s1.push(node1.right);
                s2.push(node2.right);
            }else node1.right = node1.right != null ? node1.right : node2.right;
        }
        return tree1;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

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
