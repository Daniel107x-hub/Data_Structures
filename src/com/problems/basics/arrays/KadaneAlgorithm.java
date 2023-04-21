package com.problems.basics.arrays;

public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(array));
    }
    public static int kadanesAlgorithm(int[] array) {
        int sum = array[0];
        int max = sum;
        for(int i = 1 ; i < array.length ; i++){
            int e = array[i];
            sum = Math.max(sum + e, e);
            if(sum > max) max = sum;
        }
        return max;
    }
}
