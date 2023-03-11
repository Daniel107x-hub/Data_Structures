package com.problems.trees.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricalTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1, new BinaryTree(2, new BinaryTree(3, new BinaryTree(5), new BinaryTree(6)), new BinaryTree(4)), new BinaryTree(2, new BinaryTree(4),  new BinaryTree(3, new BinaryTree(6), new BinaryTree(5))));
        System.out.println(symmetricalTree2(tree));
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

    public static boolean symmetricalTree2(BinaryTree tree){
        if(tree == null) return true;
        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();
        s1.push(tree.left);
        s2.push(tree.right);
        while(!s1.isEmpty() && !s2.isEmpty()){
            BinaryTree left = s1.pop();
            BinaryTree right = s2.pop();
            if(left == null && right == null) continue;
            if(left == null) return false;
            if(right == null) return false;
            if(left.value != right.value) return false;
            s1.push(left.left);
            s1.push(left.right);
            s2.push(right.right);
            s2.push(right.left);
        }
        if(s1.size() != s2.size()) return false;
        return true;
    }

    public static boolean symmetricalTree(BinaryTree tree) {
        if(tree == null) return true;
        List<BinaryTree> left = traverse(tree.left);
        List<BinaryTree> right =reverse(tree.right);
        if(left.size() != right.size()) return false;
        for(int i = 0 ; i < left.size() ; i++){
            if(left.get(i) == null && right.get(i) == null) continue;
            if(left.get(i).value != right.get(i).value) return false;
        }
        return true;
    }


    public static List<BinaryTree> traverse(BinaryTree tree){
        List<BinaryTree> result = new ArrayList<>();
        if(tree == null) return result;
        Stack<BinaryTree> s = new Stack<>();
        s.push(tree);
        while(!s.isEmpty()){
            BinaryTree current = s.pop();
            result.add(current);
            if(current == null) continue;
            if(current.left != null) s.push(current.left);
            if(current.right != null) s.push(current.right);
        }
        return result;
    }

    public static List<BinaryTree> reverse(BinaryTree tree){
        List<BinaryTree> result = new ArrayList<>();
        if(tree == null) return result;
        Stack<BinaryTree> s = new Stack<>();
        s.push(tree);
        while(!s.isEmpty()){
            BinaryTree current = s.pop();
            result.add(current);
            if(current == null) continue;
            if(current.right != null) s.push(current.right);
            if(current.left != null) s.push(current.left);
        }
        return result;
    }

}
