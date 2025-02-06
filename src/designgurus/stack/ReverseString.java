package designgurus.stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("Hello World!"));
    }

    public static String reverseString(String s){
        if(s.isEmpty()) return s;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) stack.push(c);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
}
