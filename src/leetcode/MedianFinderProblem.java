package leetcode;

import java.util.PriorityQueue;

public class MedianFinderProblem {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

    static class MedianFinder{
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;
        public MedianFinder(){
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>((x, y) -> y - x);
        }

        public void addNum(int num){
            if(maxHeap.isEmpty() || minHeap.isEmpty()){
                if(maxHeap.isEmpty()) maxHeap.add(num);
                else{
                    if(num < maxHeap.peek()){
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(num);
                    }else minHeap.add(num);
                }
            }else if(num >= minHeap.peek()) minHeap.add(num);
            else maxHeap.add(num);
            if(minHeap.size() - maxHeap.size() == 2) maxHeap.add(minHeap.poll());
            else if(maxHeap.size() - minHeap.size() == 2) minHeap.add(maxHeap.poll());
        }

        public double findMedian(){
            if(minHeap.isEmpty() && maxHeap.isEmpty()) return 0;
            if(minHeap.size() == maxHeap.size()) return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2;
            if(minHeap.size() > maxHeap.size()) return minHeap.peek();
            return maxHeap.peek();
        }
    }
}
