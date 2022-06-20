package com.datastructures.heap;

public interface IHeap<T> {
    int leftChild(int index);
    int rightChild(int index);
    int parent(int index);
    void heapifyUp(int index);
    void heapifyDown(int index);
    void swap(int index1, int index2);
    void insert(T element);
    void buildHeap(T[] array);
    T peek();
    T extractPeek() throws NoSuchMethodException;
    boolean areElementsInRightPlace(T element1, T element2);
}
