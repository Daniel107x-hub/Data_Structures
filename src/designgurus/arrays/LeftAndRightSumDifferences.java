package designgurus.arrays;

public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 6, 1};
        int[] out = findDifferenceArray(nums);
        for(int num : out) System.out.println(num);
    }

    public static int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] differenceArray = new int[n];
        for(int i = n - 2 ; i >= 0 ; i--) rightSum[i] = rightSum[i + 1] + nums[i + 1];
        for(int i = 0 ; i < n ; i++){
            if(i > 0) leftSum[i] = leftSum[i - 1] + nums[i - 1];
            differenceArray[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return differenceArray;
    }
}
