package com.problems.basics.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
//        if(nums.length == 1) return nums[0];
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : nums){
//            if(!map.containsKey(num)) map.put(num, 1);
//            else map.put(num, map.get(num) + 1);
//        }
//        int maxValue = 0;
//        int maxCount = 0;
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() > maxCount){
//                maxCount = entry.getValue();
//                maxValue = entry.getKey();
//            }
//        }
//        return maxValue;
    }
}
