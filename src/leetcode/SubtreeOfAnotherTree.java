package leetcode;

import designgurus.common.TreeNode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        TreeNode subroot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(root, subroot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        return root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
