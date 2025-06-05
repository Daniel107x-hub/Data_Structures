package mentorias.week2;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int left = 0;
        int max = 1;
        int currSize = 1;
        int[] positions = new int[128];
        Arrays.fill(positions, -1);
        positions[s.charAt(0)] = 0;
        for(int current = 1 ; current < s.length() ; current++){
            char c = s.charAt(current);
            int position = positions[c];
            while(position != -1 && left <= position){
                positions[s.charAt(left++)] = -1;
                currSize--;
            }
            positions[c] = current;
            currSize++;
            max = Math.max(currSize, max);
        }
        return max;
    }
}
