package com.problems.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConvertArray {
    private static final Scanner scanner = new Scanner(System.in);

    private static int[] readInput(){
        int inputSize = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args){
        int[] array = readInput();
        List<int[]> swaps = buildMinHeap(array);
        System.out.println(swaps.size());
        for(int[] swap: swaps){
            System.out.println(swap[0]+" "+swap[1]);
        }
    }

    private static int leftChild(int[] array, int index){
        int child = 2 * index + 1;
        if(child >= array.length){
            child = -1;
        }
        return child;
    }

    private static int rightChild(int[] array, int index){
        int child = 2 * (index + 1);
        if(child >= array.length){
            child = -1;
        }
        return child;
    }

    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void siftDown(int[] array, int index, List<int[]> swaps){
        int left = leftChild(array, index);
        int right = rightChild(array, index);
        int min = index;
        if(left >= 0 && array[left] < array[min]){
            min = left;
        }
        if(right >= 0 && array[right] < array[min]){
            min = right;
        }
        if(min != index){
            int[] swap = {min, index};
            swaps.add(swap);
            swap(array, min, index);
            siftDown(array, min, swaps);
        }
    }

    private static List<int[]> buildMinHeap(int[] array){
        List<int[]> swaps = new ArrayList<>();
        for(int index = array.length / 2 ; index >= 0; index--){
            siftDown(array, index, swaps);
        }
        return swaps;
    }
}
