package com.problems.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketsProblem {
    private static final Scanner scanner = new Scanner(System.in);

    private static String isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(Character character: s.toCharArray()){
            if(isClosingChar(character)){
                if(!stack.empty() && areSameType(character, stack.peek())){
                    stack.pop();
                }else{
                    return "NO";
                }
            }else{
                stack.push(character);
            }
        }
        if(stack.empty()){
            return "YES";
        }
        return "NO";
    }

    private static boolean isClosingChar(Character character){
        return character.equals('}') || character.equals(')') || character.equals(']');
    }

    private static boolean areSameType(Character ch1, Character ch2){
        return ch1.equals(')') && ch2.equals('(') || ch1.equals(']') && ch2.equals('[') || ch1.equals('}') && ch2.equals('{');
    }

    public static void main(String[] args){
        int lines = scanner.nextInt();
        for(int i=0;i<lines;i++){
            String text = scanner.next();
            System.out.println(isBalanced(text));
        }
    }
}
