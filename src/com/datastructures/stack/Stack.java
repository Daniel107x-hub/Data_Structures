package com.datastructures.stack;

import com.datastructures.list.DoublyLinkedListExtended;
import com.datastructures.list.IListExtended;

public class Stack<T> implements IStack<T> {

    IListExtended<T> stack = new DoublyLinkedListExtended<>();

    @Override
    public void push(T element) {
        this.stack.pushFront(element);
    }

    @Override
    public void pop() {
        this.stack.popFront();
    }

    @Override
    public T top() {
        T element;
        try{
            element = this.stack.topFront();
        }catch(NullPointerException exception){
            element =  null;
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
