package com.problems.trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSums4 {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        System.out.println(findTarget3(root, 9));
    }

    public static boolean findTarget3(TreeNode root, int k){
        if(root == null)return false;
        int target = k - root.val;
        if(set.contains(target)) return true;
        set.add(root.val);
        return findTarget3(root.left, k) || findTarget3(root.right, k);
    }

    public static boolean findTarget2(TreeNode root, int k){
        Map<Integer, Integer> map = new HashMap<>();
        buildMap(root, map);
        return traverse(root, map, k);
    }

    public static void buildMap(TreeNode root, Map<Integer, Integer> map){
        if(root == null) return;
        Integer value = map.get(root.val);
        if(value == null) value = 0;
        map.put(root.val, value + 1);
        buildMap(root.left, map);
        buildMap(root.right, map);
    }

    public static boolean traverse(TreeNode root, Map<Integer, Integer> map, int k){
        if(root == null) return false;
        int value = k - root.val;
        if(map.containsKey(value) && (root.val != value || map.get(value) > 1)) return true;
        return traverse(root.left, map, k) || traverse(root.right, map, k);
    }

    public static boolean findTarget(TreeNode root, int k){
        return findTarget(root, root, k);
    }

    public static boolean findTarget(TreeNode current, TreeNode root, int k){
        if(current == null) return false;
        TreeNode node = search(root, k - current.getVal());
        if(node != null && node != current) return true;
        return findTarget(current.getLeft(), root, k) || findTarget(current.getRight(), root, k);
    }

    public static TreeNode search(TreeNode root, int k){
        if(root == null) return null;
        if(root.getVal() == k) return root;
        if(k < root.getVal()) return search(root.left, k);
        return search(root.right, k);
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

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
