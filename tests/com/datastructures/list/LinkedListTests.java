package com.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTests {

    @Test
    public void testLinkedListValues(){
        IList<Integer> list = new LinkedList<>();
        for(int i = 0;i < 10;i++){
            list.add(i);
        }
        for(int i = 0;i < 10;i++){
            Assertions.assertEquals(i, list.get(i));
        }
        list.set(4, 10);
        Assertions.assertEquals(10, list.get(4));
    }
}
