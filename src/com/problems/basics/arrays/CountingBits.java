package com.problems.basics.arrays;

public class CountingBits {
    public static void main(String[] args){
        int[] sol = countBits(2);
        for(int num : sol) System.out.println(num);
    }

    private static int[] countBits(int n){
        int[] res = new int[n + 1];
        res[0] = 0;
        for(int i=1;i<=n;i++){
            if(i % 2 == 0) res[i] = res[i / 2];
            else res[i] = res[i - 1] + 1;
        }
        return res;
    }
}
