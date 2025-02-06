package designgurus.stack;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[}]"));
    }

    public static boolean isValid(String s){
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else{
                if(!isMatching(stack.peek(), c)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char opening, char closing){
        return opening == '(' && closing == ')' ||
                opening == '[' && closing == ']' ||
                opening == '{' && closing == '}';
    }
}
