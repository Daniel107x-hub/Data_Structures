package com.problems.trees.binary;

public class ClosestValueBST {
    public static void main(String[] args) {
        BST root = new BST(10, new BST(5, new BST(2, new BST(1), null), new BST(5)), new BST(15, new BST(13, null, new BST(14)), new BST(22)));
        System.out.println(findClosestValueInBst(root, 12));
    }

    public static int findClosestValueInBst(BST tree, int target){
        int closest = Integer.MIN_VALUE;
        BST next = tree;
        while(next != null){
           if(Math.abs(target - next.value) < Math.abs(target - closest)) closest = next.value;
           if(target > next.value) next = next.right;
           else next = next.left;
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

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
