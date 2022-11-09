package com.problems.basics.arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        for(int element : productExceptSelf(nums)){
            System.out.println(element);
        }
    }

    public static int[] productExceptSelf(int[] nums){
        int left = 1;
        int[] right = new int[nums.length];
        right[right.length - 1] = 1;
        for(int i=nums.length - 1;i>0;i--){
            right[i - 1] = right[i] * nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            int tmp = left * right[i];
            left *= nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}
