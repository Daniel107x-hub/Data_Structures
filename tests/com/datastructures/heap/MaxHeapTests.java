package com.datastructures.heap;

import org.junit.jupiter.api.Test;

public class MaxHeapTests {
    @Test
    public void testMaxHeapFunctionality(){
        IHeap<Integer> heap = new MaxHeap<>();
        Integer[] array = new Integer[10];
        for(int i=0;i<10;i++){
            array[i] = i;
        }
        heap.buildHeap(array);
    }
}
