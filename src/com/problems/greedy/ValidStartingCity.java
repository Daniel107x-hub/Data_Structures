package com.problems.greedy;

public class ValidStartingCity {
    public static void main(String[] args) {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        System.out.println(validStartingCity(distances, fuel, 10));
    }

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int min = 0;
        int current = 0;
        int start = 0;
        for(int i = 1 ; i <= distances.length ; i++){
            current += fuel[i - 1] * mpg - distances[i - 1];
            if(current < min){
                min = current;
                start = i;
            }
        }
        return start;
    }
}
