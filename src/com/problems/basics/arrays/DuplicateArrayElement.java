package com.problems.basics.arrays;

public class DuplicateArrayElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 1};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums){
        int t = nums[0];
        int h = nums[0];
        do{
            t = nums[t];
            h = nums[nums[h]];
        }while(t != h);
        t = nums[0];
        while( t != h){
            t = nums[t];
            h = nums[h];
        }
        return t;
    }
}
