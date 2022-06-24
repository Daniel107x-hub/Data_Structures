package com.datastructures.heap;

import org.junit.jupiter.api.Test;

public class MinHeapTests {

    @Test
    public void verifyMinHeapPropertyNotViolated(){
        IHeap<Integer> heap = new MinHeap<>();
        Integer[] array = new Integer[10];
        for(int i=0;i<10;i++){
            array[i] = i;
        }
        heap.buildHeap(array);
        System.out.println("Hello");

    }

}
