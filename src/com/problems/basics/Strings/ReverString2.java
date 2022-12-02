package com.problems.basics.Strings;


public class ReverString2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 2));
    }

    public static String reverseStr(String s, int k){
        if(s.length() <= 1) return s;
        char[] string = s.toCharArray();
        int p1 = 0;
        int p2 = k - 1;
        while(s.length() - p1 >= 0){
            reverseStr(string, p1, p2);
            p1 = p1 + 2 * k;
            p2 = Math.min(p1 + k - 1, s.length() - 1);
        }
        return new String(string);
    }

    public static void reverseStr(char[] s, int p1, int p2){
        while(p1 < p2){
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1++;
            p2--;
        }
    }
}
