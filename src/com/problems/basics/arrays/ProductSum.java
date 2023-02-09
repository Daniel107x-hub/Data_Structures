package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
    public static void main(String[] args) {
        List<Object> array = new ArrayList<>(Arrays.asList(5, 2, Arrays.asList(7, -1), 3, Arrays.asList(6, Arrays.asList(-13, 8), 4)));
        System.out.println(productSum(array));
    }

    public static int productSum(List<Object> array){
        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int depth){
        int sum = 0;
        for(Object element : array){
            if(element instanceof List) sum += depth * productSum((List<Object>) element, depth + 1);
            else sum += (Integer) element * depth;
        }
        return sum;
    }
}
