package com.problems.trees;

public class MinDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root){
        if(root == null) return 0;
        return minDepth(root, 1);
    }

    public static int minDepth(TreeNode node, int level){
        if(node.left == null && node.right == null) return level;
        if(node.left == null) return minDepth(node.right, level + 1);
        if(node.right == null) return minDepth(node.left, level + 1);
        int left = minDepth(node.left, level + 1);
        int right = minDepth(node.right, level + 1);
        return Math.min(left, right);
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
