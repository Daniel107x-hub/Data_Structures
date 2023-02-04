package com.problems.trees.binary;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1, new BinaryTree(2, new BinaryTree(4, new BinaryTree(8), new BinaryTree(9)), new BinaryTree(5, new BinaryTree(10), null)), new BinaryTree(3, new BinaryTree(6), new BinaryTree(7)));
        for(int element : branchSums2(root)) System.out.println(element);
    }

    public static List<Integer> branchSums2(BinaryTree root){
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        branchSums(root, sum, result);
        return result;
    }

    public static List<Integer> branchSums(BinaryTree root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> left = branchSums(root.left);
        List<Integer> right = branchSums(root.right);
        for(int element : left) result.add(element + root.value);
        for(int element : right) result.add(element + root.value);
        if(result.size() == 0) result.add(root.value);
        return result;
    }

    public static void branchSums(BinaryTree root, int sum, List<Integer> results){
        if(root == null) return;
        if(root.left == null && root.right == null){
            results.add(root.value + sum);
            return;
        }
        branchSums(root.left, sum + root.value, results);
        branchSums(root.right, sum + root.value, results);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
