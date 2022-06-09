package com.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTests {
    @Test
    public void verifyStack(){
        IStack<Integer> stack = new Stack<>();
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        for(int i=9;i>=0;i--){
            Integer element = stack.top();
            stack.pop();
            Assertions.assertEquals(i, element);
        }
        Assertions.assertTrue(stack.isEmpty());
    }
}
