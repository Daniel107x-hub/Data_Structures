package com.problems.basics.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
    private static Map<String, Boolean> palindromes = new HashMap<>();

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> palindromes = partition(s);
        for(List<String> solution : palindromes){
            for(String sub : solution){
                System.out.print(sub + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s){
        List<String> current = new ArrayList<>();
        List<List<String>> partitions = new ArrayList<>();
        backtrack(s, current, partitions, 0);
        return partitions;
    }

    public static void backtrack(String s, List<String> current, List<List<String>> partitions, int index){
        if(index >= s.length()){
            partitions.add(new ArrayList<>(current));
            return;
        }
        for(int end = index ; end < s.length() ; end++){
            String target = s.substring(index, end + 1);
            if(isPalindrome(target)){
                current.add(s.substring(index, end + 1));
                backtrack(s, current, partitions, end + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s){
        if(palindromes.containsKey(s)) return palindromes.get(s);
        int start = 0;
        int end = s.length() - 1;
        boolean result = true;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                result = false;
                break;
            }
            start++;
            end--;
        }
        palindromes.put(s, result);
        return result;
    }
}
