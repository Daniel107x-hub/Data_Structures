package com.problems.basics;

public class NthFibonacci {
    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

    public static int getNthFib(int n) {
        int[] fib = {0, 1};
        if(n <= 2) return fib[n - 1];
        for(int i = 3 ; i <= n ; i++){
            int number = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = number;
        }
        return fib[1];
    }
}
