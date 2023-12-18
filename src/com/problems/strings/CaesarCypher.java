package com.problems.strings;

public class CaesarCypher {
    public static void main(String[] args) {
        String s = "xyz";
        System.out.println(caesarCypherEncryptor(s, 2));
    }

    public static String caesarCypherEncryptor(String str, int key){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            int value = (c + key - 97) % 26 + 97;
            sb.append((char)value);
        }
        return sb.toString();
    }
}