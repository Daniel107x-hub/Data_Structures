package com.problems.basics.arrays;

public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1};
        for(int number : sortedSquares(nums)){
            System.out.println(number);
        }
    }

    public static int[] sortedSquares(int[] nums){
        if(nums.length == 1){
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        int min = findMin(nums);
        int p1, p2;
        if(min == nums.length -1){
            p1 = min - 1;
            p2 = min;
        }else{
            p1 = min;
            p2 = min + 1;
        }
        int[] result = new int[nums.length];
        int count = 0;
        while(p1 >= 0 && p2 < nums.length){
            if(Math.abs(nums[p1]) < Math.abs(nums[p2])){
                result[count] = nums[p1] * nums[p1];
                p1--;
            }else{
                result[count] = nums[p2] * nums[p2];
                p2++;
            }
            count++;
        }
        while(p1 >= 0){
            result[count] = nums[p1] * nums[p1];
            p1--;
            count++;
        }
        while(p2 < nums.length){
            result[count] = nums[p2] * nums[p2];
            p2++;
            count++;
        }
        return result;
    }

    public static int findMin(int[] nums){
        for(int i=0;i<nums.length - 1;i++){
            if(Math.abs(nums[i + 1]) > Math.abs(nums[i])){
                return i;
            }
        }
        return nums.length - 1;
    }
}
