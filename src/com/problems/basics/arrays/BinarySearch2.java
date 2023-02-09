package com.problems.basics.arrays;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        System.out.println(binarySearch(array, -10));
    }

    public static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        while(start <= end){
            int current = (start + end) / 2;
            if(array[current] == target) return current;
            else if(target > array[current]) start = current + 1;
            else end = current - 1;
        }
        return -1;
    }
}
