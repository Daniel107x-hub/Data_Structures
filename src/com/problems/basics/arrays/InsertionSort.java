package com.problems.basics.arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {8, 5, 2, 9, 5, 6, 3};
        for(int e : insertionSort(a)) System.out.print(e + " ");
    }

    public static int[] insertionSort(int[] array){
        int last = 1;
        while(last < array.length){
            for(int i = last ; i > 0 ; i--){
                if(array[i] > array[i - 1]) break;
                int tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
            }
            last++;
        }
        return array;
    }
}
