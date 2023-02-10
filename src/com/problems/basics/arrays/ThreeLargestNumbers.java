package com.problems.basics.arrays;

public class ThreeLargestNumbers {
    public static void main(String[] args) {
        int[] array = {10, 5, 9, 10, 12};
        for(int e : findThreeLargestNumbers(array)){
            System.out.print(e + " ");
        }
    }

    public static int[] findThreeLargestNumbers(int[] array){
        int[] solution = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int e : array){
            if(e > solution[2]){
                solution[0] = solution[1];
                solution[1] = solution[2];
                solution[2] = e;
            }else if(e > solution[1]){
                solution[0] = solution[1];
                solution[1] = e;
            }else if(e > solution[0]){
                solution[0] = e;
            }
        }
        return solution;
    }
}
