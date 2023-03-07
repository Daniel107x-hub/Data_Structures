package com.problems.heap;

public class TakeGifts {
    public static void main(String[] args) {
        int[] gifts = {56,41,27,71,62,57,67,34,8,71,2,12,52,1,64,43,32,42,9,25,73,29,31};
        System.out.println(pickGifts(gifts, 52));
    }

    public static long pickGifts(int[] gifts, int k){
        MaxHeap heap = new MaxHeap(gifts);
        heap.heapify();
        for(int i = 0 ; i < k ; i++){
            int current = heap.extractMax();
            current = (int) Math.floor(Math.sqrt(current));
            heap.insert(current);
        }
        int sum = 0;
        for(int i = 0 ; i < heap.size ; i++) sum += heap.array[i];
        return sum;
    }

    public static class MaxHeap{
        private final int[] array;
        private final int maxSize;
        private int size;

        public MaxHeap(int[] array) {
            this.array = array;
            this.maxSize = array.length;
            this.size = array.length;
        }

        private int parent(int i){
            return (int) Math.floor((i - 1) / 2.0);
        }

        private int leftChild(int i){
            return i * 2 + 1;
        }

        private int rightChild(int i){
            return i * 2 + 2;
        }

        private void siftUp(int i){
            int parent = this.parent(i);
            while(i > 0 && this.array[parent] > this.array[i]){
                this.swap(this.array, parent, i);
                i = parent;
            }
        }

        private void siftDown(int i){
            int replacement = i;
            int leftIndex = this.leftChild(i);
            int rightIndex = this.rightChild(i);
            if(leftIndex < this.size && this.array[leftIndex] > this.array[replacement]){
                replacement = leftIndex;
            }
            if(rightIndex < this.size && this.array[rightIndex] > this.array[replacement]){
                replacement = rightIndex;
            }
            if(replacement != i){
                this.swap(this.array, replacement, i);
                this.siftDown(replacement);
            }
        }

        private int search(int value){
            for(int i = 0 ; i < this.size ; i++){
                if(this.array[i] == value) return i;
            }
            return -1;
        }

        private void heapify(){
            for(int i = (int)Math.floor(this.size / 2.0) ; i >= 0 ; i--) this.siftDown(i);
        }

        private void delete(int value){
            int target = this.search(value);
            if(target == -1) return;
            this.swap(this.array, target, this.array[this.size - 1]);
            this.size--;
            this.heapify();
        }

        private int peek(){
            return this.array[0];
        }

        private int extractMax(){
            int value = this.array[0];
            this.swap(this.array, 0, this.size - 1);
            this.size--;
            this.siftDown(0);
            return value;
        }

        private void insert(int value){
            if(this.size == this.maxSize) throw new ArrayIndexOutOfBoundsException("Heap is full");
            this.size++;
            this.array[this.size - 1] = value;
            this.siftUp(this.size - 1);
        }

        private void swap(int[] array, int i, int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
