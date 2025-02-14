package designgurus.patterns.twoPointers;

/**
 * Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target. If no such pair exists return [-1, -1].
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] nums =  {1, 2, 3, 4, 6};
        int target = 6;
        for(int num : search(nums, target)) System.out.println(num);
    }

    /**
     * As the array is sorted, we can do the following:
     * 1. Put a pointer at the beginning of the array and one at the end
     * 2. Calculate the sum of those elements
     * 3. If the sum is equal to the target, return the index of those numbers
     * 4. If the sum is greater, we need to have lower elements. The left one is the smallest, but we can move the right pointer to the left to make it smaller.
     * 5. If the sum is instead. smaller, we need to take bigger numbers. Right pointer is at the biggest one but we can move left pointer to the right.
     */
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right && arr[left] + arr[right] != targetSum){
            int sum = arr[left] + arr[right];
            if(sum > targetSum) right--;
            else left++;
        }
        if(left == right) return new int[]{-1, -1};
        return new int[]{left, right};
    }
}
