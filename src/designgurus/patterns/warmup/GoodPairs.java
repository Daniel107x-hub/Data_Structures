package designgurus.patterns.warmup;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        System.out.println(numGoodPairs(nums));
    }

    public static int numGoodPairs(int[] nums) {
        int pairCount = 0;
        if(nums.length < 2) return pairCount;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int current = map.getOrDefault(num, 0);
            map.put(num, current + 1);
        }
        for(int count : map.values()){
            if(count > 1) pairCount += count * (count - 1) / 2;
        }
        return pairCount;
    }
}
