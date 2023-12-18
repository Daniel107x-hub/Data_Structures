package com.problems.basics.arrays;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {
    public static void main(String[] args) {
        int[] rs = {5, 5, 3, 9, 2};
        int[] bs = {3, 6, 7, 2, 1};
        System.out.println(tandemBicycle(rs, bs, false));
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest){
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int sum = 0;
        for(int i = 0 ; i < redShirtSpeeds.length ; i++){
            sum += Math.max(redShirtSpeeds[i] , fastest ? blueShirtSpeeds[blueShirtSpeeds.length - 1 - i] : blueShirtSpeeds[i]);
        }
        return sum;
    }
}
