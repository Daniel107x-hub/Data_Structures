package com.problems.basics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        for(List<Integer> permutation : permutations){
            System.out.print("[");
            for(int element : permutation){
                System.out.print(element + ",");
            }
            System.out.print("\b]");
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        return permute(nums, 0);
    }

    public static List<List<Integer>> permute(int[] nums, int index){
        List<List<Integer>> permutations = new ArrayList<>();
        if(index == nums.length - 1) permutations.add(List.of(nums[index]));
        else if(index == nums.length - 2){
            permutations.add(List.of(nums[index], nums[index + 1]));
            permutations.add(List.of(nums[index + 1], nums[index]));
        }else{
            List<List<Integer>> options = permute(nums, index + 1);
            for(List<Integer> option : options){
                for(int i = 0 ; i <= option.size() ; i++){
                    List<Integer> permutation = new ArrayList<>(option);
                    permutation.add(i, nums[index]);
                    permutations.add(permutation);
                }
            }
        }
        return permutations;
    }
}
