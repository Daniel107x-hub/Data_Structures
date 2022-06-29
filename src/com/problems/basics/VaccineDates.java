package com.problems.basics;

import java.util.Arrays;
import java.util.Scanner;

public class VaccineDates {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<testCases;i++){
            String line = scanner.nextLine();
            int[] inputs = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(vaccineDate(inputs[0], inputs[1], inputs[2]));
        }
    }

    public static String vaccineDate(int daysAgo, int lowerBound, int upperBound){
        if(daysAgo < lowerBound) {
            return("Too Early");
        }else if(daysAgo <= upperBound){
            return("Take the second dose now");
        }else{
            return("Too Late");
        }
    }
}
