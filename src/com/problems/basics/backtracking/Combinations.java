package com.problems.basics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> results = combine(1, 1);
        for(List<Integer> combination : results){
            for(int element : combination){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k){
        int[] nums = new int[n];
        for(int i = 1 ; i <= n ; i++) nums[i - 1] = i;
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            backtrack(results, new ArrayList<>(), nums, i, k);
        }
        return results;
    }

    public static List<List<Integer>> backtrack(List<List<Integer>> results, List<Integer> current, int[] nums, int index, int limit){
        if(limit - current.size() > nums.length - index) return null;
        current.add(nums[index]);
        if(current.size() == limit){
            results.add(current);
        }else{
            for(int i = index + 1 ; i < nums.length ; i++){
                backtrack(results, new ArrayList<>(current), nums, i, limit);
            }
        }
        return results;
    }
}
