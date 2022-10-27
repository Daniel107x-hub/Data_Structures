package com.problems.basics.arrays;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {1, 2, 4, 5, 6, 7, 8};
        System.out.println(search(arr, 3));
    }

    public static int search(int[] nums, int target){
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target){
        if(target > nums[end] || target < nums[start]) return -1;
        if(start == end){
            if(nums[start] == target) return start;
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binarySearch(nums, start, mid - 1, target);
        return binarySearch(nums, mid + 1, end, target);
    }
}
