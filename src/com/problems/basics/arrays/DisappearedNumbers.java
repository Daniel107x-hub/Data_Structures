package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbers {
    public static void main(String[] args){
        int[] arr = {1,1};
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for(int i=1;i<=n;i++){
            s.add(i);
        }
        for(int num : nums){
            s.remove(num);
        }
        return new ArrayList<>(s);
    }
}
