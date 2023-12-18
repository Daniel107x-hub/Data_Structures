package com.problems.basics.arrays;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){
        int j = 0;
        for(int i = 0 ; i < array.size() ; i++){
            if(array.get(i).equals(sequence.get(j))){
                if(j == sequence.size() - 1) return true;
                j++;
            }
        }
        return false;
    }
}
