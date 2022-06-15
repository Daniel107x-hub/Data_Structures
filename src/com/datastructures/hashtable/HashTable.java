package com.datastructures.hashtable;

import com.datastructures.list.DoublyLinkedList;
import com.datastructures.list.IListExtended;

import java.lang.reflect.Array;

public class HashTable<K, V> implements IHashTable<K, V>{

    private static final Integer INITIAL_SIZE = 32;
    private Integer size;
    private IListExtended<V>[] table;


    public HashTable(Class<V> clazz){
        this.size = INITIAL_SIZE;
        this.table = (DoublyLinkedList<V>[]) Array.newInstance(DoublyLinkedList.class, INITIAL_SIZE);
    }

    @Override
    public void insert(K key, V value) {
        int index = this.hash(key);
        IListExtended<V> list = this.table[index];
        if(list == null){
            list = new DoublyLinkedList<>();
            list.pushFront(value);
            this.table[index] = list;
        }else{
            list.pushFront(value);
        }
    }

    @Override
    public V search(K key){
        int index = this.hash(key);
        IListExtended<V> list = this.table[index];
        if(list == null){
            return null;
        }else{
            V element = list.search((V) key);
            return element;
        }
    }

    @Override
    public void remove(K key) {

    }

    private int hash(K key){
        return key.hashCode() % this.size;
    }
}
