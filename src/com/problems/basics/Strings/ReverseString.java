package com.problems.basics.Strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'a','b','c','d','e','f','g'};
        reverseString(s);
        for(char c : s) System.out.print(c);
    }

    public static void reverseString(char[] s){
        int p1 = 0, p2 = s.length - 1;
        while(p1 < p2){
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1++;
            p2--;
        }
    }
}
