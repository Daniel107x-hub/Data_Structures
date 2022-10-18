package com.problems.dp;

public class ClimbingStairs {
    public static void main(String[] args){
        int steps = 3;
        System.out.println(climbStairs(steps));
    }

    private static int climbStairs(int n){
        if(n <= 2) return n;
        int[] steps = {1, 2};
        for(int i=3;i<=n;i++){
            int ways = steps[0] + steps[1];
            steps[0] = steps[1];
            steps[1] = ways;
        }
        return steps[1];
    }


}
