package com.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTests {
    @Test
    public void verifyInsertedValues(){
        IList<Integer> list = new DoublyLinkedList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        Assertions.assertEquals(10, list.getSize());
        for(int i=0;i<10;i++){
            Assertions.assertEquals(i+1, list.get(i));
        }
    }

    @Test
    public void verifyRemoveOperation(){
        IList<Integer> list = new DoublyLinkedList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        list.remove(4);
        Assertions.assertEquals(4, list.get(3));
        Assertions.assertEquals(6, list.get(4));
        Assertions.assertEquals(9, list.getSize());
    }

    @Test
    public void verifyRemoveOnHead(){
        IList<Integer> list = new DoublyLinkedList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        list.remove(9);
        Assertions.assertEquals(9, list.get(list.getSize() - 1));
    }

    @Test
    public void verifyRemoveOnTail(){
        IList<Integer> list = new DoublyLinkedList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        list.remove(0);
        Assertions.assertEquals(2, list.get(0));
    }

    @Test
    public void verifyRemoveUniqueElement(){
        IList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        Assertions.assertEquals(1, list.getSize());
        list.remove(0);
        Assertions.assertNull(list.get(0));
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void verifyUpdateElement(){
        IList<Integer> list = new DoublyLinkedList<>();
        for(int i=1;i<=10;i++){
            list.add(i);
        }
        list.set(5, 20);
        Assertions.assertEquals(20, list.get(5));
    }
}
