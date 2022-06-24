package com.datastructures.heap;

public class MinHeap<T extends Comparable<T>> extends Heap<T>{
    @Override
    public boolean areElementsInRightPlace(T child, T parent) {
        return parent.compareTo(child) <= 0;
    }
}
