package com.problems.stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameOfTwoStacks {
    private static final Scanner scanner = new Scanner(System.in);

    public static int chooseMinPeek(Stack<Integer> A, Stack<Integer> B){
        if(A.peek() <= B.peek()){
            return A.pop();
        }else{
            return B.pop();
        }
    }

    public static int twoStacks(int maxSum, Stack<Integer> A, Stack<Integer> B){
        List<Integer> elements = new ArrayList<>();
        int currentSum = 0;
        int min = chooseMinPeek(A, B);
        while(currentSum + min < maxSum){
            currentSum += min;
            elements.add(min);
            min = chooseMinPeek(A, B);
        }
        return elements.size();
    }

    public static int twoStacks(int maxSum, List<Integer> A, List<Integer> B){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i=A.size()-1;i>=0;i--){
            stack1.push(A.get(i));
        }
        for(int i=B.size()-1;i>=0;i--){
            stack2.push(B.get(i));
        }
        return twoStacks(maxSum, stack1, stack2);
    }

    public static void main(String[] args){
        int games = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<games;i++){
            String line = scanner.nextLine();
            int[] setup = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            line = scanner.nextLine();
            List<Integer> A = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            line = scanner.nextLine();
            List<Integer> B = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            int maxSum = setup[2];
            System.out.println(twoStacks(maxSum, A, B));

        }
    }
}
