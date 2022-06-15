package com.datastructures.list;

public interface IListExtended<T> {
    void pushFront(T element);
    T topFront();
    void popFront();
    void pushBack(T element);
    T topBack();
    void popBack();
    boolean contains(T element);
    void remove(T element);
    boolean isEmpty();
    int getSize();
    T search(T element);
}
