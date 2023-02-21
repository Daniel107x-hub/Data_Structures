package com.problems.basics.arrays;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        for(int e : moveElementToEnd(array, 2)) System.out.print(e + " ");
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;
        while(left < right){
            if(array.get(left) == toMove && array.get(right) == toMove) right--;
            else if(array.get(left) == toMove && array.get(right) != toMove){
                swap(array, left, right);
                left++;
            }else{
                left++;
            }
        }
        return array;
    }

    public static void swap(List<Integer> array, int index1, int index2){
        int tmp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, tmp);
    }
}
