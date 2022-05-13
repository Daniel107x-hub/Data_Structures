package com.DataStructures.Lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTests {

    @Test
    public void validateArrayListValues(){
        IList<Integer> list = new ArrayList<>(Integer.class);
        for(int i=0;i<10;i++){
            list.add(i);
        }
        for(int i=0;i<10;i++){
            Assertions.assertEquals(i, list.get(i));
        }
    }
}
