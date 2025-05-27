package mentorias.week1;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[][] testCases = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "flight"}
        };
        String[] results = {
                "fl",
                ""
        };
        for(int i = 0 ; i < testCases.length ; i++){
            String result = longestCommonPrefix(testCases[i]);
            if(!result.equals(results[i])) throw new Error("Invalid test case");
        }
    }

    public static String longestCommonPrefix(String[] strs){
        StringBuilder prefix = new StringBuilder();
        if(strs.length  == 0) return prefix.toString();
        for(int currentPosition = 0 ; currentPosition < strs[0].length() ; currentPosition++){
            char currentChar = strs[0].charAt(currentPosition);
            for(String str : strs){
                if(currentPosition >= str.length() || str.charAt(currentPosition) != currentChar) break;
            }
            prefix.append(currentChar);
        }
        return prefix.toString();
    }
}
