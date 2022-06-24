package com.datastructures.heap;

import java.lang.reflect.Array;

public abstract class Heap<T> implements IHeap<T> {
    private T[] array;
    private int size;
    private static final int TEST_SIZE = 64;

    protected Heap() {

    }

    protected Heap(Class<T> clazz) {
        this.array = (T[]) Array.newInstance(clazz, TEST_SIZE);
        this.size = 0;
    }

    @Override
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    @Override
    public int rightChild(int index) {
        return 2 * (index + 1);
    }

    @Override
    public int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public void heapifyUp(int index) {
        int parentIndex = this.parent(index);
        T firstElement = this.array[index];
        T secondElement = this.array[parentIndex];
        while(!this.areElementsInRightPlace(firstElement, secondElement)){
            this.swap(index, parentIndex);
            index = parentIndex;
            parentIndex = this.parent(index);
            firstElement = this.array[index];
            secondElement = this.array[parentIndex];
        }
    }

    @Override
    public void heapifyDown(int index) {
        int leftChild = this.leftChild(index);
        int rightChild = this.rightChild(index);
        int compareIndex = index;
        if(leftChild < this.size && !this.areElementsInRightPlace(this.array[leftChild], this.array[index])){
            compareIndex = leftChild;
        }
        if(rightChild < this.size && !this.areElementsInRightPlace(this.array[rightChild], this.array[compareIndex])){
            compareIndex = rightChild;
        }
        if(index != compareIndex){
            this.swap(index, compareIndex);
            this.heapifyDown(compareIndex);
        }
    }

    @Override
    public void swap(int index1, int index2){
        T temp = this.array[index1];
        this.array[index1] = this.array[index2];
        this.array[index2] = temp;
    }

    @Override
    public void insert(T element) {
        int index = this.size;
        this.array[index] = element;
        this.heapifyUp(index);
    }

    @Override
    public void buildHeap(T[] array) {
        this.array = array;
        this.size = array.length;
        for(int i=(int)Math.floor(this.size / 2.0);i>=0;i--){
            this.heapifyDown(i);
        }
    }

    @Override
    public T peek() {
        return this.array[0];
    }

    @Override
    public T extractPeek() throws NoSuchMethodException {
        throw new NoSuchMethodException("Method not already implemented");
    }
}
