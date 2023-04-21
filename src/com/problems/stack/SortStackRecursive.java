package com.problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStackRecursive {
    public static void main(String[] args) {
        int[] elements = {-5, 2, -2, 4, 3, 1};
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(elements).forEach(list::add);
        for(int element : sortStack(list)){
            System.out.print(element + " ");
        }
    }

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if(stack.size() == 0) return stack;
        int element = pop(stack);
        stack = sortStack(stack);
        Stack<Integer> aux = new Stack<>();
        while(!stack.isEmpty() && peek(stack) > element) aux.push(pop(stack));
        push(stack, element);
        while(!aux.isEmpty()) push(stack, aux.pop());
        return stack;
    }

    public static Integer pop(ArrayList<Integer> stack){
        int index = stack.size() - 1;
        Integer element = stack.get(index);
        stack.remove(index);
        return element;
    }

    public static void push(ArrayList<Integer> stack, Integer element){
        stack.add(element);
    }

    public static Integer peek(ArrayList<Integer> stack){
        return stack.get(stack.size() - 1);
    }
}
