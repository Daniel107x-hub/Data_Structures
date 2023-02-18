package com.problems.basics.Strings;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String encode = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(runLengthEncoding(encode));
    }

    public static String runLengthEncoding(String string){
        if(string.length() == 0) return "";
        StringBuilder encoded = new StringBuilder();
        int counter = 0;
        Character current;
        Character prev = null;
        for(char c : string.toCharArray()){
            if(prev == null) prev = c;
            current = c;
            if(!current.equals(prev) || counter == 9){
                encoded.append(counter).append(prev);
                counter = 0;
            }
            counter++;
            prev = current;
        }
        encoded.append(counter).append(prev);
        return encoded.toString();
    }
}
