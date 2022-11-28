package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for(List<Integer> subset: subsets(nums)){
            for(Integer num : subset){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums){
        return subsets(nums, 0);
    }

    public static List<List<Integer>> subsets(int[] nums, int index){
        List<List<Integer>> subsets = new ArrayList<>();
        if(nums.length == 0){
            subsets.add(new ArrayList<>());
            return subsets;
        }
        if(index == nums.length - 1){
            List<Integer> set = new ArrayList<>();
            set.add(nums[index]);
            subsets.add(new ArrayList<>());
            subsets.add(set);
            return subsets;
        }else{
            List<List<Integer>> options = subsets(nums, index + 1);
            for(List<Integer> subset : options){
                List<Integer> copy = new ArrayList<>(subset);
                copy.add(nums[index]);
                subsets.add(copy);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
