package com.problems.basics.arrays;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 3, 2, 4};
        System.out.println(firstDuplicateValue(arr));
    }

    public static int firstDuplicateValue(int[] array) {
        for(int e : array){
            int index = Math.abs(e);
            if(array[index - 1] < 0) return index;
            array[index - 1] *= -1;
        }
        return -1;
    }
}
