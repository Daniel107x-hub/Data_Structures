package designgurus.stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String input = "abba";
        System.out.println(removeDuplicates(input));
    }

    public static String removeDuplicates(String str) {
        if(str.length() < 2) return str;
        Stack<Character> s = new Stack<>();
        for(Character c : str.toCharArray()){
            if(!s.isEmpty() && c.equals(s.peek())){
                s.pop();
            }else{
                s.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : s) sb.append(c);
        return sb.toString();
    }
}
