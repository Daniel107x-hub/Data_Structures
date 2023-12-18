package com.problems.dp;

import java.util.Arrays;
import java.util.Collections;

public class MinCoinsForChange {
    public static void main(String[] args) {
        int[] arr = {3, 5};
        System.out.println(minNumberOfCoinsForChange(9, arr));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for(int denom : denoms){
            for(int i = 0 ; i <= n ; i++){
                if(denom <= i) {
                    int sum = 1 + result[i - denom];
                    if(sum < 0) sum = Integer.MAX_VALUE;
                    result[i] = Math.min(result[i], sum);
                }
            }
        }
        return result[n] != Integer.MAX_VALUE ? result[n] : -1;

    }
}
