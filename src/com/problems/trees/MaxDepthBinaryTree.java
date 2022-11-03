package com.problems.trees;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(maxDepth(root));
    }
    
    public static int maxDepth(TreeNode root){
        return maxDepth(root, 0);
    }

    public static int maxDepth(TreeNode root, int depth){
        if(root == null) return depth;
        int left = maxDepth(root.left, depth + 1);
        int right = maxDepth(root.right, depth + 1);
        return Math.max(left, right);
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
