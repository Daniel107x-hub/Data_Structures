package com.problems.trees.binary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinHeightBST {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(22, 2, 5, 7, 10, 13, 14, 15, 1);
        BST root = minHeightBst(list);
        System.out.println();
    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        if(array.isEmpty()) return null;
        array.sort(Comparator.comparingInt(i -> i));
        int mid = (int) Math.floor(array.size() / 2.0);
        BST left = minHeightBst(array, 0, mid - 1);
        BST right = minHeightBst(array, mid  + 1, array.size() - 1);
        BST root = new BST(array.get(mid));
        root.left = left;
        root.right = right;
        return root;
    }

    public static BST minHeightBst(List<Integer> array, int start, int end) {
        if(start > end) return null;
        if(start == end) return new BST(array.get(start));
        int mid = (int) Math.floor((start + end) / 2.0);
        BST left = minHeightBst(array, start, mid - 1);
        BST right = minHeightBst(array, mid  + 1, end);
        BST root = new BST(array.get(mid));
        root.left = left;
        root.right = right;
        return root;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
