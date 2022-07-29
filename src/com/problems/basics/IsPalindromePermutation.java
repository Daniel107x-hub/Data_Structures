package com.problems.basics;

import java.util.Arrays;

public class IsPalindromePermutation {
    private static String isPalindromePermutation(String str){
        char[] strArray = str.toLowerCase().trim().replace(" ","").toCharArray();
        Arrays.sort(strArray);
        int maxUnpaired = 0;
        if(strArray.length % 2 == 1) maxUnpaired = 1;
        int i = 0;
        while(i < strArray.length){
            if(i < strArray.length - 1 && strArray[i] == strArray[i + 1]){
                i += 2;
            }else{
                if(maxUnpaired == 0) return "NO";
                maxUnpaired--;
                i++;
            }
        }
        return "YES";
    }

    public static void main(String[] args){
        String str = "cdcdcdcdeeeef";
        System.out.println(isPalindromePermutation(str));
    }
}
