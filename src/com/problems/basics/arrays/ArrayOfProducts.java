package com.problems.basics.arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2};
        for(int e : arrayOfProducts(arr)) System.out.print(e + " ");
    }

    public static int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        int[] left = new int[array.length + 1];
        int[] right = new int[array.length + 1];
        left[0] = 1;
        right[array.length] = 1;
        for(int i = 0 ; i < array.length ; i++){
            left[i + 1] = left[i] * array[i];
        }
        for(int i = array.length - 1 ; i >= 0 ; i--){
            right[i] = right[i + 1] * array[i];
        }
        for(int i = 0 ; i < array.length ; i++){
            result[i] = left[i] * right[i + 1];
        }
        return result;
    }
}
