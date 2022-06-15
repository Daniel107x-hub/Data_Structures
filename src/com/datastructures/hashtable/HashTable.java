package com.datastructures.hashtable;

import com.datastructures.list.DoublyLinkedList;
import com.datastructures.list.IListExtended;

import java.lang.reflect.Array;
import java.util.Objects;

public class HashTable<K, V> implements IHashTable<K, V>{

    private static final Integer INITIAL_SIZE = 32;
    private Integer size;
    private IListExtended<Node<K, V>>[] table;


    public HashTable(Class<V> clazz){
        this.size = INITIAL_SIZE;
        this.table = (IListExtended<Node<K,V>>[]) Array.newInstance(DoublyLinkedList.class, INITIAL_SIZE);
    }

    @Override
    public void insert(K key, V value) {
        int index = this.hash(key);
        IListExtended<Node<K, V>> list = this.table[index];
        Node<K, V> node = new Node<>(key, value);
        if(list == null){
            list = new DoublyLinkedList<>();
            list.pushFront(node);
            this.table[index] = list;
        }else{
            list.pushFront(node);
        }
    }

    @Override
    public V search(K key){
        int index = this.hash(key);
        IListExtended<Node<K, V>> list = this.table[index];
        if(list == null){
            return null;
        }else{
            Node<K, V> element =  list.search(new Node<>(key));
            if(element == null){
                return null;
            }
            return element.getValue();
        }
    }

    @Override
    public void remove(K key) {
        int index = this.hash(key);
        IListExtended<Node<K, V>> list =  this.table[index];
        if(list == null){
            return;
        }
        list.remove(new Node<>(key));
    }

    private int hash(K key){
        return key.hashCode() % this.size;
    }

    private class Node<K, V>{
        private K key;
        private V value;

        public Node(K key) {
            this.key = key;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
