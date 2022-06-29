package com.problems.basics;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDishes {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<testCases;i++){
            String line = scanner.nextLine();
            int[] inputs = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(maxDiff(inputs[0], inputs[1]));
        }
    }

    public static int maxDiff(int limit, int sum){
        int t2 = Math.min(limit, sum);
        return Math.abs(sum - 2 * t2);
    }
}
