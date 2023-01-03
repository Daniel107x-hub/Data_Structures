package com.problems.unclassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        List<String> combinations = letterCombinations("23");
        for(String combination : combinations){
            System.out.println(combination);
        }
    }

    public static List<String> letterCombinations(String digits){
        Map<Character, List<Character>> mappings = getMappings();
        List<String> combinations = new ArrayList<>();
        List<StringBuilder> construction = new ArrayList<>();
        backtrack(digits, combinations, construction, mappings, 0);
        return combinations;
    }

    public static void backtrack(String digits, List<String> combinations, List<StringBuilder> current, Map<Character, List<Character>> mappings, int index){
        if(index == digits.length()){
            for(StringBuilder stringBuilder : current){
                combinations.add(stringBuilder.toString());
            }
            return;
        }
        List<Character> letters = mappings.get(digits.charAt(index));
        List<StringBuilder> temporal = new ArrayList<>();
        for(char letter : letters){
            if(current.isEmpty()) current.add(new StringBuilder());
            for(StringBuilder stringBuilder : current){
                StringBuilder newStringBuilder = new StringBuilder(stringBuilder);
                newStringBuilder.append(letter);
                temporal.add(newStringBuilder);
            }
        }
        backtrack(digits, combinations, temporal, mappings, index + 1);
    }

    public static Map<Character, List<Character>> getMappings(){
        Map<Character, List<Character>> mappings = new HashMap<>();
        mappings.put('2', Arrays.asList('a','b','c'));
        mappings.put('3', Arrays.asList('d','e','f'));
        mappings.put('4', Arrays.asList('g','h','i'));
        mappings.put('5', Arrays.asList('j','k','l'));
        mappings.put('6', Arrays.asList('m','n','o'));
        mappings.put('7', Arrays.asList('p','q','r','s'));
        mappings.put('8', Arrays.asList('t','u','v'));
        mappings.put('9', Arrays.asList('w','x','y','z'));
        return mappings;
    }
}
