package com.problems.basics.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(zeroSumSubarray(arr));
    }

    public static boolean zeroSumSubarray(int[] nums) {
        if(nums.length==0) return true;
        int curr = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            curr += num;
            if(set.contains(curr)) return true;
            set.add(curr);
        }
        return false;
    }
}
