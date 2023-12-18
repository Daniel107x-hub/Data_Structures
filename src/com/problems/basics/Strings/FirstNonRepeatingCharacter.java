package com.problems.basics.Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcdcaf";
        System.out.println(firstNonRepeatingCharacter(str));
    }

    public static int firstNonRepeatingCharacter(String string){
        Map<Character, Integer> map = getFreqs(string);
        for(int i = 0 ; i < string.length() ; i++){
            if(map.get(string.charAt(i)) == 1) return i;
        }
        return -1;
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
