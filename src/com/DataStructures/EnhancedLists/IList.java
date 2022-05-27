package com.DataStructures.EnhancedLists;

public interface IList<T> {
    void pushFront(T element);
    T topFront();
    void popFront();
    void pushBack(T element);
    T topBack();
    void popBack();
    boolean contains(T element);
    void remove(T element);
    boolean isEmpty();
}
