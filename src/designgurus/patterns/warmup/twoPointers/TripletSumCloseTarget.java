package designgurus.patterns.warmup.twoPointers;

import java.util.Arrays;

public class TripletSumCloseTarget {
    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 2};
        int target = 1;
        System.out.println(searchTriplet(arr, target));
    }

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        int smallestSum = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length - 2 ; i++){
            int current = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right){
                int sum = current + arr[left] + arr[right];
                int diff = Math.abs(targetSum - sum);
                if(diff < smallestDiff || (diff == smallestDiff && sum < smallestSum)){
                    smallestDiff = diff;
                    smallestSum = sum;
                }
                int leftSum = sum - arr[left] + arr[left + 1];
                int leftDiff = Math.abs(targetSum - leftSum);
                int rightSum = sum - arr[right] + arr[right - 1];
                int rightDiff = Math.abs(targetSum - rightSum);
                if(leftDiff < rightDiff) left++;
                else right--;
            }
        }
        return smallestSum;
    }
}
