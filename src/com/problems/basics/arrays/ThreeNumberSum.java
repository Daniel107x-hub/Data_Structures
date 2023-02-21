package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer[]> result = threeNumberSum(arr, 6);
        for(Integer[] sol : result){
            for(int num : sol) System.out.print(num + " ");
            System.out.println();
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for(int i = 0 ; i <= array.length - 3 ; i++){
            int current = i;
            int left = i + 1;
            int right = array.length - 1;
            while(left < right){
                int sum = array[current] + array[left] + array[right];
                if(sum == targetSum){
                    result.add(new Integer[]{array[current], array[left], array[right]});
                    left++;
                    right--;
                }else if(sum < targetSum) left++;
                else right--;
            }
        }
        return result;
    }
}
