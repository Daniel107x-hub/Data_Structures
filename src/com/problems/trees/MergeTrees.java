package com.problems.trees;

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode root = mergeTrees(root1, root2);
        System.out.println("Hey!");
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return null;
        TreeNode current;
        if(root1 == null){
            current = root2;
            current.left = mergeTrees(null, root2.left);
            current.right = mergeTrees(null, root2.right);
        }else if(root2 == null){
            current = root1;
            current.left = mergeTrees(root1.left, null);
            current.right = mergeTrees(root1.right, null);
        }else{
            current = root1;
            current.val += root2.val;
            current.left = mergeTrees(root1.left, root2.left);
            current.right = mergeTrees(root1.right, root2.right);
        }
        return current;
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
