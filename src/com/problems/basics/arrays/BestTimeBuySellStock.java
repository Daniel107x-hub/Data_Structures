package com.problems.basics.arrays;

public class BestTimeBuySellStock {
    public static void main(String[] args){
        int[] prices = {16,17,3,1,11};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices){
        int maxProfit = 0;
        int minPointer = 0;
        for(int i=1;i<prices.length;i++){
            int diff = prices[i] - prices[minPointer];
            if(diff > maxProfit) maxProfit = diff;
            if(prices[i] < prices[minPointer]) minPointer = i;
        }
        return maxProfit;
    }
}
