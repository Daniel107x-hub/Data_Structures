package com.problems.trees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class AverageOfLevels {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Double> mean = averageOfLevels(root);
        for(double value: mean){
            System.out.println(value);
        }
    }

    private static double round(double value, int places){
        if(places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> currentLevel = new ArrayList<>();
        List<Double> meanList = new ArrayList<>();
        double sum;
        int count;
        currentLevel.add(root);
        while(true){
            List<TreeNode> childrenLevel = new ArrayList<>();
            sum = 0;
            count = 0;
            for(TreeNode node : currentLevel){
                sum += node.val;
                count++;
                if(node.left != null){
                    childrenLevel.add(node.left);
                }
                if(node.right != null){
                    childrenLevel.add(node.right);
                }
            }
            double mean = round(sum / count, 5);
            meanList.add(mean);
            if(childrenLevel.isEmpty()){
                break;
            }
            currentLevel = childrenLevel;
        }
        return meanList;
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
