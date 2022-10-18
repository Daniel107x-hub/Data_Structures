package com.problems.dp;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
        tests();
    }

    private static void tests(){
        String input = "a";
        System.out.println(longestPalindrome(input));
    }

    private static boolean isPalindrome(String s){
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int start, int end){
        if(start >= end) return true;
        return s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1);
    }

    private static boolean isPalindromeCached(String s, int start, int end, Boolean[][] cache){
        if(start >= end) return true;
        if(cache[start][end] != null) return cache[start][end];
        boolean result = s.charAt(start) == s.charAt(end) && isPalindromeCached(s, start + 1, end - 1, cache);
        cache[start][end] = result;
        return result;
    }

    private static String longestBruteForce(String s){
        String longest = s.substring(0,1);
        for(int start = 0;start<s.length() - 1;start++){
            for(int end = 1;end<s.length();end++){
                if(isPalindrome(s, start, end) && end - start + 1 > longest.length()) longest = s.substring(start, end + 1);
            }
        }
        return longest;
    }

    private static String longestPalindrome(String s){
        String longest = s.substring(0,1);
        Boolean[][] cache = new Boolean[s.length()][s.length()];
        for(int start = 0;start<s.length() - 1;start++){
            for(int end = 1;end<s.length();end++){
                if(isPalindromeCached(s, start, end, cache) && end - start + 1 > longest.length()) longest = s.substring(start, end + 1);
            }
        }
        return longest;
    }
}
