package com.problems.trees;

public class KthSmallestElementBST {
    static int element = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k){
        if(element == -1) element = k;
        TreeNode next = root.left;
        if(next != null){
            int num = kthSmallest(next, k);
            if(num >= 0) return num;
        }
        element--;
        if(element == 0) return root.val;
        next = root.right;
        if(next != null){
            int num = kthSmallest(next, k);
            if(num >= 0) return num;
        }
        return -1;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){};

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
