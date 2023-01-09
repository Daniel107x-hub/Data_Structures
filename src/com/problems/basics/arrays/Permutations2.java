package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        List<List<Integer>> result = permute(nums);
        for(List<Integer> permute  :result){
            for(Integer element : permute){
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    public static List<List<Integer>> permute(int[] nums, int index){
        List<List<Integer>> permutations = new ArrayList<>();
        if(index == nums.length - 1) permutations.add(List.of(nums[index]));
        else if(index == nums.length - 2){
            permutations.add(List.of(nums[index], nums[index + 1]));
            List<Integer> permutation = List.of(nums[index + 1], nums[index]);
            if(!elementIsInList(permutation, permutations)) permutations.add(permutation);
        }else{
            List<List<Integer>> options = permute(nums, index + 1);
            for(List<Integer> option : options){
                for(int i = 0 ; i <= option.size() ; i++){
                    List<Integer> permutation = new ArrayList<>(option);
                    permutation.add(i, nums[index]);
                    if(!elementIsInList(permutation, permutations)) permutations.add(permutation);
                }
            }
        }
        return permutations;
    }

    public static boolean elementIsInList(List<Integer> element, List<List<Integer>> list){
        for(List<Integer> item : list){
            if(item.size() != element.size()) continue;
            for(int i = 0 ; i < item.size() ; i++){
                if(item.get(i) != element.get(i)) break;
                if(i == item.size() - 1 && item.get(i) == element.get(i)) return true;
            }
        }
        return false;
    }
}
