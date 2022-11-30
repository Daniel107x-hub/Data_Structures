package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        for(List<Integer> subset : subsets){
            for(Integer e : subset) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums){
        int[] count = new int[21];
        for(int num : nums) count[num + 10] += 1;
        List<List<Integer>> subsets = subsetsWithDup(count, 0);
        subsets.add(new ArrayList<>());
        return subsets;
    }

    public static List<List<Integer>> subsetsWithDup(int[] count, int index){
        List<List<Integer>> subsets = new ArrayList<>();
        if(count.length == 0){
            subsets.add(new ArrayList<>());
            return subsets;
        }
        if(count.length == 1 || index == count.length - 1){
            subsets.addAll(getCurrentSubsets(count, index, null));
        }else{
            List<List<Integer>> options = subsetsWithDup(count, index + 1);
            if(options.size() == 0){
                subsets.addAll(getCurrentSubsets(count, index, null));
            }else {
                if(count[index] != 0) {
                    subsets.addAll(getCurrentSubsets(count, index, null));
                }
                for (List<Integer> option : options) {
                    subsets.add(option);
                    subsets.addAll(getCurrentSubsets(count, index, option));
                }
            }
        }
        return subsets;
    }

    public static List<List<Integer>> getCurrentSubsets(int[] count, int index, List<Integer> option){
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 1; i <= count[index]; i++) {
            List<Integer> subset;
            if(option != null) subset = new ArrayList<>(option);
            else subset = new ArrayList<>();
            for (int j = 1; j <= i; j++) subset.add(index - 10);
            subsets.add(subset);
        }
        return subsets;
    }
}
