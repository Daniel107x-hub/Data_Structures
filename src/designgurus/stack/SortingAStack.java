package designgurus.stack;

import java.util.Stack;

public class SortingAStack {
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(34);
        input.push(3);
        input.push(31);
        input.push(98);
        input.push(92);
        input.push(23);
        Stack<Integer> result = sortStack(input);
        while(!result.isEmpty()) System.out.println(result.pop());
    }

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty()){
            int current = input.pop();
            while(!tmpStack.isEmpty() && current < tmpStack.peek()) input.push(tmpStack.pop());
            tmpStack.push(current);
        }
        return tmpStack;
    }
}
