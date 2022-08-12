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
        int sum = 0;
        int maxElements = 0;
        int i = 0;
        while(i<A.size()){
            int aElement = A.get(i);
            if(sum + aElement <= maxSum){
                sum += aElement;
                maxElements++;
                i++;
            }else{
                int j = 0;
                while(j < B.size()){
                    int bElement = B.get(j);
                    if(sum + bElement <= maxSum){
                        sum += bElement;
                        maxElements++;
                        j++;
                    }else{
                        break;
                    }
                }
                break;
            }
        }

        int maxElements2 = 0;
        sum = 0;
        i = 0;
        while(i < B.size()){
            int bElement = B.get(i);
            if(sum + bElement <= maxSum){
                sum += bElement;
                maxElements2++;
                i++;
            }else{
                int j = 0;
                while(j < A.size()){
                    int aElement = A.get(j);
                    if(sum + aElement <= maxSum){
                        sum += aElement;
                        maxElements2++;
                        j++;
                    }else{
                        break;
                    }
                }
                break;
            }
        }

        return Math.max(maxElements, maxElements2);
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
