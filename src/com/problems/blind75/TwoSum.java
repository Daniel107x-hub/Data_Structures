package com.problems.blind75;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] solution = Solution.twoSumUsingMap(nums, 9);
        System.out.println("The index solution are: " + solution[0] + ", " + solution[1]);
    }
}

class Solution {
    public static int[] twoSum(int[] nums, int target){
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums.length ; j++){
                if(i == j) continue;
                if(nums[i] + nums[j] != target) continue;
                int[] result = {i, j};
                return result;
            }
        }
        return new int[2];
    }

    public static int[] twoSumUsingMap(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length ; i++){
            int remainder = target - nums[i];
            Integer index = map.get(remainder);
            if(index == null || i == index) continue;
            int[] solution = {i, index};
            return solution;
        }
        return new int[2];
    }

    public static int[] twoSumUsingMapSinglePass(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int remainder = target - nums[i];
            if(map.containsKey(remainder)){
                return new int[]{i, map.get(remainder)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
