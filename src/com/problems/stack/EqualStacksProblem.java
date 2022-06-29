package com.problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EqualStacksProblem {
    private static final Scanner scanner = new Scanner(System.in);

    public static int minStack(Stack s1, Stack s2, Stack s3){
        int min = Math.min(s1.getHeight(), s2.getHeight());
        return Math.min(min, s3.getHeight());
    }

    public static int equalStacks(List<Integer> s1, List<Integer> s2, List<Integer> s3){
        Stack stack1 = new Stack(s1);
        Stack stack2 = new Stack(s2);
        Stack stack3 = new Stack(s3);
        return equalStacks(stack1, stack2, stack3);
    }

    public static int equalStacks(Stack s1, Stack s2, Stack s3){
        int max = minStack(s1, s2, s3);
        while(s1.getHeight() > max && s1.getHeight() > 0){
            s1.pop();
        }
        while(s2.getHeight() > max && s2.getHeight() > 0){
            s2.pop();
        }
        while(s3.getHeight() > max && s3.getHeight() > 0){
            s3.pop();
        }
        if(s1.getHeight() == s2.getHeight() && s1.getHeight() == s3.getHeight()){
            return s1.getHeight();
        }
        return equalStacks(s1, s2, s3);
    }

    public static void main(String[] args){
        String line = scanner.nextLine();
        int[] sizes = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<List<Integer>> stacks = new ArrayList<>();
        for(int size: sizes){
            line = scanner.nextLine();
            int[] elements = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            List<Integer> stack = new ArrayList<>();
            for(int element: elements){
                stack.add(element);
            }
            stacks.add(stack);
        }
        System.out.println(equalStacks(stacks.get(0), stacks.get(1), stacks.get(2)));
    }

    public static class Stack{
        int height;
        List<Integer> elements;

        public Stack() {}

        public Stack(List<Integer> elements) {
            this.elements = new ArrayList<>();
            for(int i=elements.size()-1;i>=0;i--){
                this.push(elements.get(i));
            }
        }

        public void push(int element){
            if(this.elements == null){
                this.elements = new ArrayList<>();
            }
            this.elements.add(element);
            this.height += element;
        }

        public void pop(){
            if(this.elements == null) return;
            int lastIndex = elements.size() - 1;
            int element = this.elements.get(lastIndex);
            this.elements.remove(lastIndex);
            this.height -= element;
        }

        public int getHeight() {
            return height;
        }
    }
}
