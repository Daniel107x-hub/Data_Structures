package com.DataStructures.Stack;

public interface IStack<T> {
    void push(T element);
    void pop();
    T top();
    boolean isEmpty();
}
