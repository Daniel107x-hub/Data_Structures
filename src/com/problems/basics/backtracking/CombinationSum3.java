package com.problems.basics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum3(3, 7);
        for(List<Integer> combination : results){
            for(int element : combination){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int target){
        List<List<Integer>> results = new ArrayList<>();
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0 ; i < candidates.length ; i++){
            backtrack(results, new ArrayList<>(), 0, candidates, target, i, k);
        }
        return results;
    }

    public static void backtrack(List<List<Integer>> results, List<Integer> current, int currentSum, int[] nums, int target, int index, int maxDepth){
        int num = nums[index];
        if(currentSum + num > target) return;
        if(current.size() == maxDepth) return;
        current.add(num);
        currentSum += num;
        if(currentSum == target && current.size() == maxDepth){
            results.add(current);
        }else{
            for(int i = index + 1 ; i < nums.length ; i++){
                if(currentSum + nums[i] <= target) backtrack(results, new ArrayList<>(current), currentSum, nums, target, i, maxDepth);
            }
        }
    }
}
