package com.problems.strings;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    private static final char A_CHARACTER = 'a';

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] counts = new int[27];
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            int pos = s.charAt(i) - A_CHARACTER;
            counts[pos]++;
        }
        for(int i = 0 ; i < len ; i++){
            int pos = t.charAt(i) - A_CHARACTER;
            counts[pos]--;
        }
        return Arrays
                .stream(counts)
                .noneMatch(e -> e != 0);
    }

    public static boolean isAnagramSorting(String s, String t){
        if(s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i = 0 ; i < s1.length ; i++){
             if(s1[i] != s2[i]) return false;
        }
        return true;
    }
}
