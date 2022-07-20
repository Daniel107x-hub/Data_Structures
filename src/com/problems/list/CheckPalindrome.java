package com.problems.list;

import java.util.LinkedList;
import java.util.Stack;

public class CheckPalindrome {

    public static boolean isPalindrome(LinkedList<Character> list){
        Stack<Character> stack = new Stack<>();
        for(Character item: list){
            stack.push(item);
        }
        for(Character item: list){
            if(!item.equals(stack.peek())){
                return false;
            }
            stack.pop();
        }
        return true;
    }

    public static  void main(String[] args){
        LinkedList<Character> list = new LinkedList<>();
        list.add('h');
        list.add('e');
        list.add('l');
        list.add('t');
        list.add('l');
        list.add('e');
        list.add('h');
        System.out.println(isPalindrome(list));

    }
}
