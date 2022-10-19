package com.problems.basics.arrays;

public class RangeSumQuery {
    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));
    }

    private static class NumArray{
        private int[] sums;

        public NumArray(int[] nums){
            int[] sums = new int[nums.length];
            sums[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                sums[i] = sums[i-1] + nums[i];
            }
            this.sums = sums;
        }

        public int sumRange(int left, int right){
            int leftSum = 0;
            if(left > 0) leftSum = this.sums[left - 1];
            return this.sums[right] - leftSum;
        }
    }
}
