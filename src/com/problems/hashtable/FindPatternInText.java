package com.problems.hashtable;

import java.util.ArrayList;
import java.util.List;

public class FindPatternInText {
    private static final int P = 1000000007;
    private static final int X = 263;

    public static void main(String[] args){
        tests();
    }

    public static void tests(){
        String pattern = "Test";
        String text = "testTesttesT";
        List<Integer> matches = findMatches(pattern, text);
        System.out.println(matches);
    }

    private static int hash(String s){
        long hashCode = 0L;
        for(int i=s.length()-1;i>=0;i--){
            int charCode = s.charAt(i);
            hashCode = ((hashCode * X + charCode) % P + P) % P;
        }
        return (int)hashCode;
    }

    private static int[] precomputeHashes(String text, int length){
        int[] hashes = new int[text.length() - length + 1];
        String substring = text.substring(text.length() - length, text.length());
        hashes[text.length() - length] = hash(substring);
        int y = 1;
        for(int i=1;i<=length;i++){
            y = ((y * X) % P + P) % P;
        }
        for(int i=text.length()-length-1;i>=0;i--){
            hashes[i] = ((X * hashes[i + 1] + (int)text.charAt(i) - y * (int)text.charAt(i + length)) % P + P) % P;
        }
        return hashes;
    }

    private static List<Integer> findMatches(String pattern, String text){
        List<Integer> positions = new ArrayList<>();
        int patternHash = hash(pattern);
        int[] hashes = precomputeHashes(text, pattern.length());
        for(int i=0;i<=text.length()-pattern.length();i++){
            if(patternHash!=hashes[i]) continue;
            if(pattern.equals(text.substring(i, i + pattern.length()))){
                positions.add(i);
            }
        }
        return positions;
    }
}
