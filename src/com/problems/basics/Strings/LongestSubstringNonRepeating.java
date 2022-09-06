package com.problems.basics.Strings;

import java.util.*;

public class LongestSubstringNonRepeating {
    public static void main(String[] args){
        String s = "tmmzuxt";
        System.out.println(maxLength2(s));
    }

    public static int maxLength(String s){
        int max = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            Set<Character> set = new HashSet<>();
            int count = 0;
            for(int j=i;j<chars.length;j++){
                char current = chars[j];
                if(set.contains(current)) break;
                set.add(current);
                count += 1;
                if(count > max) max = count;
            }
        }
        return max;
    }

    public static int maxLength2(String s){
        int max = 0, count = 0;
        int start = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars){
            if(set.contains(c)){
                while(chars[start] != c){
                    set.remove(chars[start]);
                    start++;
                    count--;
                }
                set.remove(c);
                start++;
                count--;
            }
            set.add(c);
            count++;
            if(count > max) max = count;
        }
        return max;
    }
}
