package com.problems.trees;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null|| subRoot == null) return subRoot == root;
        boolean isSubtree = false;
        if(root.val == subRoot.val){
            isSubtree = validateSubtree(root.left, subRoot.left) && validateSubtree(root.right, subRoot.right);
        }
        return isSubtree || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean validateSubtree(TreeNode root, TreeNode subRoot){
        if(root == null|| subRoot == null) return subRoot == root;
        if(root.val != subRoot.val) return false;
        return validateSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);

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
