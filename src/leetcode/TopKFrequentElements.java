package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 0};
        for(int num: topKFrequent(nums, 1)){
            System.out.print(num + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int num : nums){
            Node node = map.getOrDefault(num, new Node(num));
            node.freq++;
            map.put(num, node);
        }
        pq.addAll(map.values());
        int[] result = new int[k];
        if(pq.size() < k) return result;
        while(k > 0) result[--k] = pq.poll().val;
        return result;
    }

    static class Node {
        int val;
        int freq;
        public Node(int val){
            this.val = val;
            this.freq = 0;
        }
    }
}
