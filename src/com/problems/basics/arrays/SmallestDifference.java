package com.problems.basics.arrays;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] arr1 = {-1, 5, 10, 20, 28, 3};
        int[] arr2 = {26, 134, 135, 15, 17};
        for(int e : smallestDifference(arr1, arr2)) System.out.print(e + " ");
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(left < arrayOne.length && right < arrayTwo.length){
            int diff = Math.abs(arrayOne[left] - arrayTwo[right]);
            if(diff < min){
                result[0] = arrayOne[left];
                result[1] = arrayTwo[right];
                min = diff;
            }
            if(diff == 0) break;
            else if(arrayOne[left] < arrayTwo[right]) left++;
            else right++;
        }
        return result;
    }
}
