package com.problems.unclassified;

public class SingleCycleCheck {
    public static void main(String[] args) {
        int[] arr = {10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(arr));
    }

    public static boolean hasSingleCycle(int[] arr){
        int elements = 0;
        int current = 0;
        while(elements < arr.length){
            elements++;
            current = getNextPosition(arr, current);
        }
        for(int e : arr) if(e != 0) return false;
        return current == 0;
    }

    public static int getNextPosition(int[] arr, int index){
        int next = index + arr[index];
        arr[index] = 0;
        if(next >= 0) return next % arr.length;
        return (arr.length + next % arr.length) % arr.length;
    }
}
