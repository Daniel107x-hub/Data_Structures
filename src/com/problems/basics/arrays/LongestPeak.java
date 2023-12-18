package com.problems.basics.arrays;

public class LongestPeak {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(arr));
    }

    public static int longestPeak(int[] array) {
        // Write your code here.
        int start = 0;
        int peak;
        int end;
        int maxLen = 0;
        int curr;
        while(start < array.length - 2){
            curr = start;
            while(curr < array.length - 1 && array[curr + 1] > array[curr]) curr++;
            peak = curr;
            while(curr < array.length - 1 && array[curr + 1] < array[curr]) curr++;
            end = curr;
            if(peak == start || end == peak){
                start++;
                continue;
            }
            int len = end - start + 1;
            if(len > maxLen) maxLen = len;
            start = end;
        }
        return maxLen;
    }
}
