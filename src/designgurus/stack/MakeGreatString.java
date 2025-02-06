package designgurus.stack;

import java.util.Stack;

public class MakeGreatString {
    public static void main(String[] args) {
        String input = "";
        System.out.println(makeGood(input));
    }

    public static String makeGood(String str) {
        if(str.length() < 2) return str;
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()){
            if(!s.isEmpty() && Character.toLowerCase(c) == Character.toLowerCase(s.peek()) && c != s.peek()) s.pop();
            else s.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : s) sb.append(c);
        return sb.toString();
    }
}
