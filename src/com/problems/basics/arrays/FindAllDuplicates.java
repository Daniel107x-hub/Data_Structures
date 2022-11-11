package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4};
        for(int num : findDuplicates(nums)){
            System.out.println(num);
        }
    }

    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> duplicates = new ArrayList<>();
        for(int num : nums){
            int element = Math.abs(num) - 1;
            if(nums[element] < 0){
                duplicates.add(element + 1);
            }else{
                nums[element] *= -1;
            }
        }
        return duplicates;
    }
}
