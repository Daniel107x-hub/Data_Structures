package com.problems.dp;

import java.util.HashSet;
import java.util.Set;

public class FindJudge {
    public static void main(String[] args) {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int n = 4;
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust){
        Set<Integer> set = new HashSet<>();
        int[] votes = new int[n];
        for(int i = 1 ; i <= n ; i++){
            set.add(i);
            votes[i - 1] = 0;
        }
        for(int[] vote : trust){
            set.remove(vote[0]);
            votes[vote[1] - 1]++;
        }
        Integer[] result = set.toArray(new Integer[0]);
        if(result.length != 1) return -1;
        if(votes[result[0] -1] != n-1) return -1;
        return result[0];
    }
}
