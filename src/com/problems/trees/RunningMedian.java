package com.problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunningMedian {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(12, 4, 5, 3, 8, 7);
        List<Double> medians = runningMedian(elements);
        for(double result : medians) System.out.println(result);
    }

    public static List<Double> runningMedian(List<Integer> a){
        List<Double> results = new ArrayList<>();
        BinaryHeap maxHeap = new MaxHeap(a.size());
        BinaryHeap minHeap = new MinHeap(a.size());
        double median = 0.0;
        int elements = 0;
        for(int element : a){
            if(element > median) minHeap.insert(element);
            else maxHeap.insert(element);
            elements++;
            if(maxHeap.elements - minHeap.elements > 1){
                minHeap.insert(maxHeap.extractPeek());
            }else if(minHeap.elements - maxHeap.elements > 1){
                maxHeap.insert(minHeap.extractPeek());
            }
            if(elements % 2 == 0) median = (double)(maxHeap.peek() + minHeap.peek()) / 2;
            else median = maxHeap.elements > minHeap.elements ? maxHeap.peek() : minHeap.peek();
            results.add(median);
        }
        return results;
    }

    public static class MaxHeap extends BinaryHeap{

        public MaxHeap(int size) {
            super(size);
        }

        @Override
        public boolean compare(int i, int j) {
            return i > j;
        }
    }

    public static class MinHeap extends BinaryHeap{

        public MinHeap(int size) {
            super(size);
        }

        @Override
        public boolean compare(int i, int j) {
            return i <= j;
        }
    }

    private abstract static class BinaryHeap{
        private int[] heap;
        private int last = -1;
        public int elements;

        public BinaryHeap(int size) {
            this.heap = new int[size];
        }

        private int leftChild(int i){
            return 2 * i + 1;
        }

        private int rightChild(int i){
            return 2 * ( i + 1);
        }

        private int parent(int i){
            return (int) Math.floor((double) (i - 1) / 2);
        }

        private void swap(int i, int j){
            int tmp = this.heap[i];
            this.heap[i] = this.heap[j];
            this.heap[j] = tmp;
        }

        private void siftUp(int i){
            int parentIndex = this.parent(i);
            while(i > 0 && this.compare(this.heap[i], this.heap[parentIndex])){
                this.swap(i, parentIndex);
                i = parentIndex;
                parentIndex = this.parent(i);
            }
        }

        private void siftDown(int i){
            if(i >= this.last) return;
            int index = i;
            int leftIndex = this.leftChild(i);
            if(leftIndex <= this.last && !this.compare(this.heap[index], this.heap[leftIndex])) index = leftIndex;
            int rightIndex = this.rightChild(i);
            if(rightIndex <= this.last && !this.compare(this.heap[index], this.heap[rightIndex])) index = rightIndex;
            if(index != i){
                this.swap(i, index);
                siftDown(index);
            }
        }

        public void insert(int element){
            if(this.elements == this.heap.length) throw new IllegalStateException("Heap is already full");
            this.last++;
            this.elements++;
            this.heap[this.last] = element;
            this.siftUp(this.last);
        }

        public int extractPeek(){
            if(this.elements == 0) throw new IllegalStateException("Heap is empty");
            int tmp = this.heap[0];
            this.heap[0] = this.heap[last];
            this.last--;
            this.elements--;
            this.siftDown(0);
            return tmp;
        }

        public int peek(){
            if(this.elements == 0) throw new IllegalStateException("Heap is empty");
            return this.heap[0];
        }

        public abstract boolean compare(int i, int j);
    }
}
