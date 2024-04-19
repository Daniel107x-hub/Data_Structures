package com.problems.blind75;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatignCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int solution = lengthOfLongestSubstring(s);
        System.out.println(solution);
    }

    public static int lengthOfLongestSubstring(String s){
        if(s.length() <= 1) return s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 1;
        set.add(s.charAt(left));
        int currentCount = 1;
        int maxCount = 1;
        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
                currentCount--;
            }
            set.add(s.charAt(right));
            currentCount++;
            maxCount = Math.max(maxCount, currentCount);
            right++;
        }
        return maxCount;
    }

}