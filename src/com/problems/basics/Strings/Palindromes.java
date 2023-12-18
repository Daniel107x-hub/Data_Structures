package com.problems.basics.Strings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Palindromes {
    public static void main(String[] args) {
        String[] words = {"diaper", "abc", "test", "cba", "repaid"};
        ArrayList<ArrayList<String>> results = semordnilap(words);
        for(ArrayList<String> result : results){
            for(String word : result) System.out.print(word + " ");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words){
        Set<String> set = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(String word : words){
            set.remove(word);
            String reversed = reverseString(word);
            if(set.contains(reversed)){
                ArrayList<String> pair = new ArrayList<>();
                pair.add(word);
                pair.add(reversed);
                result.add(pair);
                set.remove(reversed);
            }
        }
        return result;
    }

    public static String reverseString(String word){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = word.length() - 1 ; i >= 0 ; i--) stringBuilder.append(word.charAt(i));
        return stringBuilder.toString();
    }
}
