package com.problems.basics;

import java.util.HashMap;
import java.util.Map;

public class OneAway {
    private static boolean isOneAway(String s1, String s2){
        Map<Character, Integer> map = new HashMap<>();
        if(Math.abs(s1.length() - s2.length()) > 1) return false;
        for(Character letter: s1.toCharArray()){
            int currentCount = 0;
            if(map.containsKey(letter)){
                currentCount = map.get(letter);
            }
            map.put(letter, currentCount + 1);
        }
        for(Character letter: s2.toCharArray()){
            int currentCount = 0;
            if(map.containsKey(letter)) {
                currentCount = map.get(letter);
                if (currentCount == 1) {
                    map.remove(letter);
                    continue;
                }
            }
            map.put(letter, currentCount - 1);
        }
        if(map.keySet().size() == 1 && Math.abs((Integer)map.values().toArray()[0]) != 1) return false;
        if(map.keySet().size() == 2 && (Math.abs((Integer)map.values().toArray()[0]) != 1 || Math.abs((Integer)map.values().toArray()[1]) != 1)) return false;
        if(map.keySet().size() > 2) return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(isOneAway("pale","palee"));
    }
}
