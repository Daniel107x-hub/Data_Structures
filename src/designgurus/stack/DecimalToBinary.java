package designgurus.stack;


import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(18));
    }

    public static String decimalToBinary(int num){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        while(num > 0){
            s.push(num % 2);
            num /= 2;
        }
        while(!s.isEmpty()) sb.append(s.pop());
        return sb.toString();
    }
}
