package com.problems.basics.Strings;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "nzp#o#g";
        String t = "b#nzp#o#g";
        System.out.println(backspaceCompare2(s, t));
    }

    public static boolean backspaceCompare(String s, String t){
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!s1.empty()) s1.pop();
            }
            else s1.push(c);
        }
        for(char c : t.toCharArray()){
            if(c == '#'){
                if(!s2.empty()) s2.pop();
            }
            else s2.push(c);
        }
        while(!s1.empty() && !s2.empty()){
            if(s1.pop() != s2.pop()) return false;
        }
        return s1.empty() && s2.empty();
    }

    public static boolean backspaceCompare2(String s, String t){
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        int[] backspaces = {0, 0};
        while(p1 >= 0 || p2 >= 0){
            while(p1 >= 0) {
                if (s.charAt(p1) == '#') {
                    backspaces[0]++;
                    p1--;
                } else if (backspaces[0] > 0) {
                    backspaces[0]--;
                    p1--;
                } else {
                    break;
                }
            }
            while(p2 >= 0) {
                if (t.charAt(p2) == '#') {
                    backspaces[1]++;
                    p2--;
                } else if (backspaces[1] > 0) {
                    backspaces[1]--;
                    p2--;
                } else {
                    break;
                }
            }
            if(p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2)) return false;
            if(p1 >= 0 != p2 >= 0) return false;
            p1--;
            p2--;
        }
        return true;
    }
}
