package designgurus.stack;

import java.util.Stack;

public class RemoveStars {
    public static void main(String[] args) {
        String input = "";
        System.out.println(removeStars(input));
    }

    public static String removeStars(String str){
        if(str.isEmpty()) return str;
        Stack<Character> s = new Stack<>();
        for(Character c : str.toCharArray()){
            if(c.equals('*') && !s.isEmpty()) s.pop();
            else if (!c.equals('*')) s.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : s) sb.append(c);
        return sb.toString();
    }
}
