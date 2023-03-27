package com.problems.unclassified;

public class SingleCycleCheck {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -2, 3, 7, 8, -26};
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
        if(next >= 0) return next % (arr.length);
        return arr.length - Math.abs(next) % (arr.length);
    }
}
