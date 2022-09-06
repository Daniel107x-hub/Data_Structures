package com.problems.basics.arrays;

public class Median2SortedArrays {
    public static void main(String[] args){
        int[] left = {1, 2};
        int[] right = {3, 4};
        System.out.println(median(left, right));
    }

    private static int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while(i < left.length && j< right.length){
            if(left[i] < right[j]){
                merged[k] = left[i];
                i++;
            }else{
                merged[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            merged[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length){
            merged[k] = right[j];
            j++;
            k++;
        }
        return merged;
    }

    private static double median(int[] left, int[] right){
        int[] arr = merge(left, right);
        if(arr.length % 2 == 1) return arr[arr.length / 2];
        return (double)(arr[(int)(Math.ceil((double)arr.length / 2))] + arr[(int)(Math.ceil((double)arr.length / 2)) - 1]) / 2;
    }
}
