package com.DataStructures.Stack;

import com.DataStructures.EnhancedLists.DoublyLinkedList;
import com.DataStructures.EnhancedLists.IList;

public class Stack<T> implements IStack<T> {

    IList<T> stack = new DoublyLinkedList<>();

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
