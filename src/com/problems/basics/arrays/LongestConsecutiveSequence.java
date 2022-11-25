package com.problems.basics.arrays;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(longestConsecutiveSorted(nums));
    }

    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int longest = 0;
        for(int num : set){
            int current = 1;
            int cnum = num;
            while(set.contains(cnum + 1)){
                current++;
                cnum++;
            }
            if(current > longest) longest = current;
        }
        return longest;
    }

    public static int longestConsecutiveSorted(int[] nums){
        SortedSet<Integer> set = new TreeSet<>();
        if(nums.length == 0) return 0;
        for(int num : nums) set.add(num);
        int current = 1;
        int longest = 0;
        Integer nnum;
        Iterator<Integer> setIterator = set.iterator();
        Integer cnum = setIterator.next();
        while(setIterator.hasNext()){
            nnum = setIterator.next();
            if(nnum == cnum + 1) current++;
            else current = 1;
            if(current > longest) longest = current;
            cnum = nnum;
        }
        return Math.max(longest, current);
    }
}
