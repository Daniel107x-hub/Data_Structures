package com.problems.stack;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String expression = ")";
        System.out.println(isBalanced(expression));
    }

    public static String isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(isOpenType(c)) stack.push(c);
            else{
                if(!stack.isEmpty() && isSameType(stack.peek(), c)) stack.pop();
                else return "NO";
            }
        }
        if(stack.isEmpty()) return "YES";
        return "NO";
    }

    private static boolean isSameType(Character first, Character second){
        return first == '[' && second == ']' ||
                first == '{' && second == '}' ||
                first == '(' && second == ')';
    }

    private static boolean isOpenType(Character bracket){
        return bracket == '(' || bracket == '[' || bracket == '{';
    }
}
