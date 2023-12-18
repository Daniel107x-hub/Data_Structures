package com.problems.basics.arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {8, 5, 2, 9, 5, 6, 3};
        for(int e : selectionSort(a)) System.out.print(e + " ");
    }

    public static int[] selectionSort(int[] array){
        for(int i = 0 ; i < array.length - 1; i++){
            int minIndex = i;
            for(int j = i ; j < array.length ; j++){
                if(array[j] < array[minIndex]) minIndex = j;
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
