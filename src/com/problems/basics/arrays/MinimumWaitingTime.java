package com.problems.basics.arrays;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(queries));
    }

    public static int minimumWaitingTime(int[] queries){
        Arrays.sort(queries);
        int factor = queries.length - 1;
        int sum = 0;
        for(int i = 0 ; i < queries.length - 1 ; i++){
            sum += queries[i] * factor;
            factor--;
        }
        return sum;
    }
}
