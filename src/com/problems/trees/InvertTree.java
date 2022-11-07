package com.problems.trees;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        root = invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
