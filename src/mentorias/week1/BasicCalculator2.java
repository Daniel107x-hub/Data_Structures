package mentorias.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        String s = "1-1+1";
        System.out.println(calculate(s));
    }

    public static int calculate(String s){
        List<String> list = convertToList(s);
        return evaluate(list);
    }

    private static List<String> convertToList(String s){
        s = s.replaceAll(" ", "");
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            StringBuilder element = new StringBuilder();
            boolean isNumeric = Character.isDigit(s.charAt(i));
            while(i < s.length() && Character.isDigit(s.charAt(i)) == isNumeric) element.append(s.charAt(i++));
            result.add(element.toString());
        }
        return result;
    }

    private static int evaluate(List<String> list){
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        for(String s : list.reversed()){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                operators.push(s.charAt(0));
            } else {
                operands.push(Integer.parseInt(s));
            }
        }
        while(operators.size() > 1){
            Character currentOperator = operators.pop();
            Character nextOperator = operators.pop();
            Integer firstOperand = operands.pop();
            Integer secondOperand = operands.pop();
            if(hasLowerPriority(currentOperator, nextOperator)){
                int result = calculate(secondOperand, nextOperator, operands.pop());
                operands.push(result);
                operands.push(firstOperand);
                operators.push(currentOperator);
            }else{
                int result = calculate(firstOperand, currentOperator, secondOperand);
                operands.push(result);
                operators.push(nextOperator);
            }
        }
        if(operators.size() == 1) operands.push(calculate(operands.pop(), operators.pop(), operands.pop()));
        return operands.pop();
    }

    private static boolean hasLowerPriority(Character op1, Character op2){
        return ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/'));
    }

    private static int calculate(Integer n1, Character operand, Integer n2){
        return switch (operand) {
            case '*' -> n1 * n2;
            case '-' -> n1 - n2;
            case '/' -> n1 / n2;
            default -> n1 + n2;
        };
    }
}
