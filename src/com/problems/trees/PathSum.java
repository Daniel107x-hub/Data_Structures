package com.problems.trees;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null) return false;
        return hasPathSum(root, targetSum, 0);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum, int currentSum){
        if(root.left == null && root.right == null) return targetSum == currentSum + root.val;
        boolean leftSum = false;
        boolean rightSum = false;
        if(root.left != null) leftSum = hasPathSum(root.left, targetSum, currentSum + root.val);
        if(root.right != null) rightSum = hasPathSum(root.right, targetSum, currentSum + root.val);
        return rightSum || leftSum;
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
