package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {
    public static void main(String[] args) {
        String string = "a1b2";
        for(String response : letterCasePermutation(string)){
            System.out.println(response);
        }
    }

    public static List<String> letterCasePermutation(String s){
        return letterCasePermutation(s, 0);
    }

    public static List<String> letterCasePermutation(String s, int index){
        List<String> list = new ArrayList<>();
        char current = s.charAt(index);
        if(index == s.length() - 1){
            list.add(s.substring(index));
            if(Character.isAlphabetic(current)){
                if(Character.isUpperCase(current)){
                    list.add(s.substring(index).toLowerCase());
                }else{
                    list.add(s.substring(index).toUpperCase());
                }
            }
        }else{
            List<String> options = letterCasePermutation(s, index + 1);
            for(String option : options){
                list.add(current + option);
                if(Character.isAlphabetic(current)){
                    if(Character.isUpperCase(current)){
                        list.add(Character.toLowerCase(current) + option);
                    }else{
                        list.add(Character.toUpperCase(current) + option);
                    }
                }
            }
        }
        return list;
    }
}
