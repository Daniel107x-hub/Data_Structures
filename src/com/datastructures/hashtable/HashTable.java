package com.datastructures.hashtable;

import com.datastructures.list.IListExtended;

public class HashTable<K, V> implements IHashTable<K, V>{

    private static final Integer INITIAL_SIZE = 32;
    private Integer size;


    public HashTable(){
        this.size = INITIAL_SIZE;
    }

    @Override
    public void insert(K key, V value) {}

    @Override
    public V search(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }
}
