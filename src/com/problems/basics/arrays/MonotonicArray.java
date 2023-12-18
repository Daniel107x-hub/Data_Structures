package com.problems.basics.arrays;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(array));
    }

    public static boolean isMonotonic(int[] array) {
        if(array.length <= 2) return true;
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;
        for(int i = 1 ; i < array.length ; i++){
            if(array[i] > array[i - 1]) isNonIncreasing = false;
            if(array[i] < array[i - 1]) isNonDecreasing = false;
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
