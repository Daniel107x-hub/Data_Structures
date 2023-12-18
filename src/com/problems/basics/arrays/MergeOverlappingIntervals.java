package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{10, 20}, {20, 30}, {30, 40}, {40, 50}, {50, 60}, {60, 70}, {70, 80}, {80, 90}, {90, 100}};
        for(int[] result : mergeOverlappingIntervals(arr)){
            for(int e : result) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for(int[] interval : intervals){
            if(interval[0] <= currentInterval[1]) currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            else{
                result.add(currentInterval);
                currentInterval = interval;
            }
        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][2]);
    }
}
