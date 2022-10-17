package com.problems.basics.arrays;

public class MissingNumber {
    public static void main(String[] args){
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums){
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for(int num : nums){
            sum -= num;
        }
        return sum;
    }
}
