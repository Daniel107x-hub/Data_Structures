package com.datastructures.queue;

public interface IQueue<T> {
    void enqueue(T value);
    T dequeue();
    T peek();
    boolean isEmpty();
}
