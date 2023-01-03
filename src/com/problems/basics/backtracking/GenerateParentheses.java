package com.problems.basics.backtracking;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {
        for(String result  : generateParentheses(3)){
            System.out.println(result);
        }
    }

    static List<String> generateParentheses(int n){
        List<String> results = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), results);
        return results;
    }

    static void backtrack(int open, int close, StringBuilder current, List<String> results){
        if(open > close) return; // There are more ) than (, that is not possible.
        if(open == 0 && close == 0){
            String result = current.toString();
            if(isValid(result)) results.add(result);
            return;
        }
        StringBuilder openOption = new StringBuilder(current);
        StringBuilder closeOption = new StringBuilder(current);
        if(open > 0){
            openOption.append('(');
            backtrack(open - 1, close, openOption, results);
        }
        if(close > 0){
            closeOption.append(')');
            backtrack(open, close - 1, closeOption, results);
        }
    }

    static boolean isValid(String option){
        Stack<Character> stack = new Stack<>();
        for(char p : option.toCharArray()){
            if(p == '(') stack.push(p);
            else{
                try {
                    stack.pop();
                }catch (EmptyStackException e){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
