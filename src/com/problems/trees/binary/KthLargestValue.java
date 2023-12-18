package com.problems.trees.binary;

import java.util.Stack;

public class KthLargestValue {
    public static void main(String[] args) {
        BST root = new BST(15, new BST(5, new BST(2, new BST(1), new BST(3)), new BST(5)), new BST(20, new BST(17), new BST(22)));
        System.out.println(findKthLargestValueInBst(root, 10));
    }

    public static int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        Stack<BST> s = new Stack<>();
        BST current = tree;
        while(k > 0){
            if(current != null){
                s.push(current);
                current = current.right;
            }else{
                current = s.pop();
                k--;
                if(k == 0) return current.value;
                current = current.left;
            }
        }
        return current.value;
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

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
