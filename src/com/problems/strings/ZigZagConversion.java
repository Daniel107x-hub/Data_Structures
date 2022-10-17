package com.problems.strings;

import java.util.Arrays;

public class ZigZagConversion {

    public static void main(String[] args){
        tests();
    }

    public static void tests(){
        String input = "AB";
        int rows = 1;
        String result = convert(input, rows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows){
        StringBuilder[] strings = new StringBuilder[Math.min(numRows, s.length())];
        int current = 0;
        boolean goingDown = true;
        for(int i=0;i<s.length();i++){
            if(strings[current] == null) strings[current] = new StringBuilder();
            strings[current].append(s.charAt(i));
            if(numRows == 1) continue;
            if(i != 0 && i % (numRows - 1) == 0) goingDown = !goingDown;
            if(goingDown) current++;
            else current--;
        }
        return Arrays.stream(strings).reduce((acc, currentSB)-> acc.append(currentSB)).get().toString();
    }
}
