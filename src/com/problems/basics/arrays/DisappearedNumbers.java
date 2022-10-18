package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbers {
    public static void main(String[] args){
        int[] arr = {1,1};
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        for(int num : nums){
            int index = Math.abs(num) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        List<Integer> excluded = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) excluded.add(i + 1);
        }
        return excluded;
    }
}
