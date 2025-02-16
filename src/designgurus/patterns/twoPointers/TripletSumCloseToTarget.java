package designgurus.patterns.twoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static void main(String[] args) {

    }

    public static int searchTriplets(int[] arr, int target) {
        if(arr.length < 3) return 0;
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0 ; i < arr.length - 2 ; i++){
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum < target){
                    count += right - left;
                    left++;
                }
                else right--;
            }
        }
        return count;
    }
}
