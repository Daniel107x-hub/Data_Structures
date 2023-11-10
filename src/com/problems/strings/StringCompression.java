package com.problems.strings;

public class StringCompression {
    public static void main(String[] args) {
        String s  = "aaaaaaaaaabbccaa";
        System.out.println(compress(s));
    }

    private static String compress(String s){
        if(s.length() < 1) return s;
        StringBuilder sb = new StringBuilder();
        Character currChar;
        Character nextChar;
        int currCount = 0;
        for(int i = 0 ; i < s.length() ; i++){
            currChar = s.charAt(i);
            nextChar = i == s.length() - 1 ? null : s.charAt(i + 1);
            if(currChar != nextChar){
                sb.append(currChar).append(currCount + 1);
                currCount = 0;
            }else{
                currCount++;
            }
        }
        if(s.length() <= sb.length()) return s;
        return sb.toString();
    }
}
