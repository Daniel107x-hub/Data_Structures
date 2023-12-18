package com.problems.basics.arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 2, 5};
        for(int e : bubbleSort(array)) System.out.print(e + " ");
    }

    public static int[] bubbleSort(int[] array){
        boolean isSorted = false;
        int end = array.length - 1;
        while(!isSorted){
            isSorted = true;
            for(int  i = 0 ; i < end ; i++){
                if(array[i] > array[i+1]){
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    isSorted = false;
                }
            }
            end--;
        }
        return array;
    }
}
