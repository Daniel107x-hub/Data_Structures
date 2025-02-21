package designgurus.patterns.twoPointers;

public class SubarraysWithProductLessThanTarget {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        System.out.println(findSubarrays(nums, 0));
    }

    public static int findSubarrays(int[] nums, int target) {
        int totalCount = 0;
        int product = 1;
        int left = 0;
        for(int right = 0 ; right < nums.length ; right++){
            product *= nums[right];
            while(product >= target && left <= right){
                product /= nums[left];
                left++;
            }
            totalCount += (right - left) + 1;
        }
        return totalCount;
    }

}
