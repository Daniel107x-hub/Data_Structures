package com.problems.basics.arrays;

public class WaterArea {
    public static void main(String[] args) {
        int[] heights = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(heights));
    }

    public static int waterArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for(int i = 1 ; i < heights.length ; i++) {
            if(heights[i - 1] > left[i - 1]) left[i] = heights[i - 1];
            else left[i] = left[i - 1];
        }
        for(int i = heights.length - 2 ; i >= 0 ; i--) {
            if(heights[i + 1] > right[i + 1]) right[i] = heights[i + 1];
            else right[i] = right[i + 1];
        }
        int area = 0;
        for(int i = 0 ; i < heights.length ; i++) {
            if(heights[i] < left[i] && heights[i] < right[i]) area += Math.min(left[i], right[i]) - heights[i];
        }
        return area;
    }
}
