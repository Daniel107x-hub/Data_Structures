package com.problems.bitmanipulation;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x){
        boolean isNegative = x < 0;
        int absValue = Math.abs(x);
        String stringNumber = Integer.toString(absValue);
        Stack<Character> stack  = new Stack<>();
        for(char digit : stringNumber.toCharArray()){
            stack.push(digit);
        }
        StringBuilder revertedString = new StringBuilder();
        if(isNegative) revertedString.append("-");
        while(!stack.empty()){
            revertedString.append(stack.pop());
        }
        try {
            return Integer.parseInt(revertedString.toString());
        }catch(NumberFormatException e){
            return 0;
        }
    }
}
