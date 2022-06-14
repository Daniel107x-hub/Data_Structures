package com.datastructures.hashtable;

public interface IHashTable<K,V> {
    void insert(K key, V value);
    V search(K key);
    void remove(K key);
}
