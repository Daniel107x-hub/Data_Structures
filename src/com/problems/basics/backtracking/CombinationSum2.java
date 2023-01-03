package com.problems.basics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        List<List<Integer>> results = combinationSum(nums, 5);
        for(List<Integer> combination : results){
            for(int element : combination){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        int lastCandidate = 0;
        for(int i = 0 ; i < candidates.length ; i++){
            if(candidates[i] == lastCandidate) continue;
            backtrack(results, new ArrayList<>(), 0, candidates, target, i);
            lastCandidate = candidates[i];
        }
        return results;
    }

    public static void backtrack(List<List<Integer>> results, List<Integer> current, int currentSum, int[] nums, int target, int index){
        int num = nums[index];
        if(currentSum + num > target) return;
        current.add(num);
        currentSum += num;
        if(currentSum == target){
            results.add(current);
        }else{
            int lastCandidate = 0;
            for(int i = index + 1 ; i < nums.length ; i++){
                if(nums[i] == lastCandidate) continue;
                if(currentSum + nums[i] <= target) backtrack(results, new ArrayList<>(current), currentSum, nums, target, i);
                lastCandidate = nums[i];
            }
        }
    }
}
