package com.problems.basics.arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {
        int[] array = {-4, 2, 3, 5, 6, 8, 9};
        for(int num : sortedSquaredArray(array)){
            System.out.print(num + " ");
        }
    }

    public static int[] sortedSquaredArray(int[] array){
        int minIndex = 0 ;
        int maxIndex = array.length - 1;
        int endIndex = maxIndex;
        int[] output = new int[array.length];
        while(minIndex <= maxIndex){
            if(Math.abs(array[maxIndex]) > Math.abs(array[minIndex])){
                output[endIndex] = array[maxIndex] * array[maxIndex];
                maxIndex--;
            }else{
                output[endIndex] = array[minIndex] * array[minIndex];
                minIndex++;
            }
            endIndex--;
        }
        return output;
    }
}
