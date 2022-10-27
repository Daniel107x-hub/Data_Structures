package com.problems.basics.arrays;

public class SmallestLetterInList {
    public static void main(String[] args){
        char[] letters = {'e', 'e', 'g', 'g'};
        System.out.println(nextGreatestLetter(letters, 'g'));
    }

    public static char nextGreatestLetter(char[] letters, char target){
        if(letters[0] > target || letters[letters.length - 1] < target) return letters[0];
        return greatestLetter(letters, 0, letters.length - 1, target);
    }

    public static char greatestLetter(char[] letters, int start, int end, char target){
        if(start >= end){
            if(letters[start] == target){
                start++;
                while(start < letters.length){
                    if(letters[start] != target) return letters[start];
                    start++;
                }
                return letters[0];
            }
            if(letters[start] <= target) return letters[start + 1];
            return letters[start];
        }
        int mid = (int) Math.ceil(end + start) / 2;
        if(letters[mid] >= target) return greatestLetter(letters, start, mid, target);
        return greatestLetter(letters, mid + 1, end, target);
    }
}
