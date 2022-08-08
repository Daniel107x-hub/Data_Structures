package com.problems.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParallelProcessing {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String[] firstLine = scanner.nextLine().split(" ");
        int threads = Integer.parseInt(firstLine[0]);
        int elements = Integer.parseInt(firstLine[1]);
        List<Long> times = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
        List<Long[]> results = simulateSchedulerPQ(threads, times);
        for(Long[] result : results){
            System.out.println(result[0]+" "+result[1]);
        }
    }

    private static List<Long[]> simulateScheduler(int n, List<Long> times){
        List<Long[]> operations = new ArrayList<>();
        Long[] threads = new Long[n];
        Arrays.fill(threads, 0L);
        for(Long time:times){
            int index = minIndex(threads);
            Long[] operation = {(long) index, threads[index]};
            operations.add(operation);
            threads[index] += time;
        }
        return operations;
    }

    private static int minIndex(Long[] arr){
        int min = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }

    private static List<Long[]> simulateSchedulerPQ(int n, List<Long> times){
        List<Long[]> operations = new ArrayList<>();
        PriorityQueue queue = new PriorityQueue(n);
        for(Long time:times){
            Node minNode = queue.getMin();
            Long[] operation = {minNode.index, minNode.time};
            operations.add(operation);
            minNode.time += time;
            queue.updatePriority();
        }
        return operations;
    }

    private static class PriorityQueue{
        private int workers;
        private MinHeap heap;

        public PriorityQueue(int workers) {
            this.workers = workers;
            this.heap = new MinHeap(workers);
        }

        public Node getMin(){
            return this.heap.getRoot();
        }

        public void updatePriority(){
            this.heap.updateHeap();
        }
    }

    private static class MinHeap{

        private int workers;
        private Node[] heap;

        public MinHeap(int workers) {
            this.workers = workers;
            Node[] workersArray = new Node[workers];
            for(int i=0;i<workers;i++){
                workersArray[i] = new Node(i);
            }
            this.heap = workersArray;
        }

        private int leftChild(Node[] array, int index){
            int child = 2 * index + 1;
            if(child >= array.length){
                child = -1;
            }
            return child;
        }

        private int rightChild(Node[] array, int index){
            int child = 2 * (index + 1);
            if(child >= array.length){
                child = -1;
            }
            return child;
        }

        private void swap(Node[] array, int a, int b){
            Node temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

        public void updateHeap(){
            this.siftDown(this.heap, 0);
        }

        private void siftDown(Node[] array, int index){
            int left = this.leftChild(array, index);
            int right = this.rightChild(array, index);
            int min = index;
            if(left >= 0 && array[left].finishesBefore(array[min])){
                min = left;
            }
            if(right >= 0 && array[right].finishesBefore(array[min])){
                min = right;
            }
            if(min != index){
                swap(array, min, index);
                siftDown(array, min);
            }
        }

        public Node getRoot(){
            return this.heap[0];
        }
    }

    private static class Node{
        private long time;
        private long index;

        public Node(int index){
            this.index = index;
            this.time = 0;
        }

        public Node(long time, int index) {
            this.time = time;
            this.index = index;
        }

        public boolean finishesBefore(Node node){
            if(this.time != node.time) return this.time < node.time;
            return this.index < node.index;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public long getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
