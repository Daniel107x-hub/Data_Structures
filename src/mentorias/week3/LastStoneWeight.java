package mentorias.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) q.add(stone);
        while(q.size() > 1){
            int s1 = q.poll();
            int s2 = q.poll();
            int result = Math.abs(s1 - s2);
            if(result != 0) q.add(result);
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}
