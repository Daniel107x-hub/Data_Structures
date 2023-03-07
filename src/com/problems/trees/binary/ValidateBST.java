package com.problems.trees.binary;

public class ValidateBST {
    public static void main(String[] args) {
        BST tree = new BST(10,new BST(5, null, new BST(10)), new BST(15));
        System.out.println(validateBst(tree));
    }

    public static boolean validateBst(BST tree){
        if(tree == null) return true;
        boolean left = validateBst(tree.left, null, tree.value);
        boolean right = validateBst(tree.right, tree.value, null);
        return left && right;
    }

    public static boolean validateBst(BST root, Integer min, Integer max){
        if(root == null) return true;
        boolean isValid = true;
        if(min != null) isValid = root.value >= min;
        if(max != null) isValid &= root.value < max;
        if(!isValid) return isValid;
        return validateBst(root.left, min, root.value) && validateBst(root.right, root.value, max);
    }

    static class BST{
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
