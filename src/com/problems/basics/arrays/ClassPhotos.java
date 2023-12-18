package com.problems.basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {
    public static void main(String[] args) {
        int[] redA = {5, 8, 1, 3, 4};
        ArrayList<Integer> red = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blue = new ArrayList<>(Arrays.asList(6, 9, 2, 2, 5));
        System.out.println(classPhotos(red, blue));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights){
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean isRedTaller = redShirtHeights.get(0) > blueShirtHeights.get(0);
        boolean isPossible = true;
        for(int i = 1 ; i < redShirtHeights.size() ; i++){
            isPossible &= isRedTaller ? redShirtHeights.get(i) > blueShirtHeights.get(i) : blueShirtHeights.get(i) > redShirtHeights.get(i);
            if(!isPossible) break;
        }
        return isPossible;
    }
}
