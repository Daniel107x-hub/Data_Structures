package mentorias.week1;

import java.util.Stack;

// Given a string with characters {, }, [, ], (, ), determine if the input is a valid parentheses sequence
public class ValidParentheses {
    public static void main(String[] args) {
        String[] tests = {
                "()",
                "()[]{}",
                "(]",
                "([])"
        };
        boolean[] results=  {
                true,
                true,
                false,
                true
        };
        for(int i = 0 ; i < tests.length ; i++){
            boolean result = isValid(tests[i]);
            if(result != results[i]) throw new Error("Invalid test case");
        }
    }

    private static boolean isValid(String s){
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(isOpeningParentheses(c)) stack.push(c);
            else if(stack.isEmpty() || !parenthesesMatch(stack.pop(), c)) return false;
        }
        return stack.isEmpty();
    }

    private static boolean parenthesesMatch(char p1, char p2){
        return p1 == '[' && p2 == ']' || p1 == '{' && p2 == '}' || p1 == '(' && p2 == ')';
    }

    private static boolean isOpeningParentheses(char p){
        return p == '{' || p == '[' || p == '(';
    }
}


