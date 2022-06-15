package com.datastructures.hashtable;

import org.junit.jupiter.api.Test;

public class HashTableTests {

    @Test
    public void insertElementsToHashTable(){
        IHashTable<Integer, String> table = new HashTable<>(String.class);
        table.insert(0, "Hello");
        table.insert(1, " ");
        table.insert(2, "World");
        String result = table.search(0);
        System.out.println("Hello ");
    }
}
