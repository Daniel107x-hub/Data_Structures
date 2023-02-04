package com.problems.basics.arrays;

import java.util.Arrays;

public class NonConstructibleChange{
    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(coins));
    }

    public static int nonConstructibleChange(int[] coins){
        Arrays.sort(coins);
        int change = 0;
        for(int coin : coins){
            if(coin > change + 1) break;
            change+=coin;
        }
        return change + 1;
    }
}
