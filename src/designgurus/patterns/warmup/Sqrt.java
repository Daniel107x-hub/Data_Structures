package designgurus.patterns.warmup;

import java.math.BigInteger;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }

    public static int sqrt(int x){
        if(x < 2) return x;
        int left = 2;
        int right = x / 2;
        while(left < right){
            int current = left + (right - left) / 2;
            long num = (long) current * current;
            if(num == x) return current;
            if(num > x) right = current - 1;
            if(num < x) left = current + 1;
        }
        return right;
    }
}
