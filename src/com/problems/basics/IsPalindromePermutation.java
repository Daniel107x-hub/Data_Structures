package com.problems.basics;

import java.util.Arrays;

public class IsPalindromePermutation {
    private static String isPalindromePermutation(String str){
        char[] strArray = str.toLowerCase().trim().replace(" ","").toCharArray();
        Arrays.sort(strArray); ///nlogn
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

    public static boolean isPalindromePermutationArray(String s){
        int[] count = new int[27];
        for(char c : s.replace(" ","").toCharArray()){
            int position  = c - 'a';
            if(count[position] == 1){
                count[position] = 0;
            }else {
                count[position] = 1;
            }
        }
        return Arrays.stream(count).sum() <= 1;
    }

    public static boolean isPermutationOfPalindrome(String s){
        int vector = createVector(s); //[]
        return vector == 0 || checkOneBitSet(vector);
    }

    /*
        1 byte = 8 bits
        int -> 4 bytes -> 32 bits
     */
    public static int createVector(String s){
        int vector = 0; //[00000000 00000000 00000000 00000100]
        for(char c : s.toCharArray()){
            int x = c - 'a';
            vector = toggle(vector, x);
        }
        return vector;
    }

    public static int toggle(int vector, int index){
        if(index < 0) return vector;
        int mask = 1 << index;
        if((vector & mask) == 0) vector |= mask;
        else vector &= ~mask;
        return vector;
    }

    public static boolean checkOneBitSet(int vector){
        /*
        [0100] - 1 -> [0011]
        [1100] - 1 -> [1011]
         */
        return (vector & (vector - 1)) == 0;
    }

    public static void main(String[] args){
        String str = "abcba";
        System.out.println(isPermutationOfPalindrome(str));
    }
}
