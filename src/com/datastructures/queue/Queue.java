package com.datastructures.queue;

import com.datastructures.list.DoublyLinkedListExtended;
import com.datastructures.list.IListExtended;

public class Queue<T> implements IQueue<T>{

    private IListExtended<T> list;

    public Queue(){
        this.list = new DoublyLinkedListExtended<>();
    }

    @Override
    public void enqueue(T value) {
        this.list.pushBack(value);
    }

    @Override
    public T dequeue() {
        if(this.list.isEmpty()){
            throw new IllegalStateException("Collection is empty");
        }
        T element = this.list.topFront();
        this.list.popFront();
        return element;
    }

    @Override
    public T peek() {
        if(this.list.isEmpty()){
            throw new IllegalStateException("Collection is empty");
        }
        return this.list.topFront();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
