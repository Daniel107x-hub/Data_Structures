package com.problems.basics.Strings;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    public static void main(String[] args) {
        String chars = "abcabcc";
        String document = "aabbccc";
        System.out.println(generateDocument(chars, document));
    }

    public static boolean generateDocument(String characters, String document){
        Map<Character, Integer> freqs = getFreqs(characters);
        for(char c : document.toCharArray()){
            if(!freqs.containsKey(c) || freqs.get(c) <= 0) return false;
            freqs.put(c, freqs.get(c) - 1);
        }
        return true;
    }

    public static Map<Character, Integer> getFreqs(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }
}
