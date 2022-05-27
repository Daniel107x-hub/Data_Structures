package com.DataStructures.EnhancedLists;

public class DoublyLinkedList<T> implements IList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    @Override
    public void pushFront(T element) {
        Node<T> newNode = new Node<>(element);
        if(this.size == 0){
            this.tail = newNode;
        }else{
            Node<T> front = this.head;
            newNode.setNext(front);
            front.setPrevious(newNode);
        }
        this.head = newNode;
        this.size++;
    }

    @Override
    public T topFront() {
        if(this.head != null) {
            return this.head.getValue();
        }
        return null;
    }

    @Override
    public void popFront() {
        Node<T> front = this.head;
        if(this.size == 0){
            return;
        }
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else if(this.size > 1){
            Node<T> next = front.getNext();
            next.setPrevious(null);
            this.head = next;
        }
        this.size--;
    }

    @Override
    public void pushBack(T element) {
        Node<T> newNode = new Node<>(element);
        if(this.size == 0){
            this.head = newNode;
        }else{
            Node<T> back = this.tail;
            back.setNext(newNode);
            newNode.setPrevious(back);
        }
        this.tail = newNode;
        this.size++;
    }

    @Override
    public T topBack() {
        if(this.tail == null){
            return null;
        }
        return this.tail.getValue();
    }

    @Override
    public void popBack() {
        Node<T> back = this.tail;
        if(this.size == 0){
            return;
        }else if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else{
            Node<T> previous = back.getPrevious();
            previous.setNext(null);
            this.tail = previous;
        }
        this.size--;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currentElement = this.head;
        while(currentElement != null){
            if(currentElement.getValue() == element){
                return true;
            }
            currentElement = currentElement.getNext();
        }
        return false;
    }

    @Override
    public void remove(T element) {
        Node<T> currentElement = this.head;
        if(this.size == 0){
            return;
        }else if(this.size == 1){
            if(currentElement.getValue() == element){
                this.head = null;
                this.tail = null;
                this.size--;
            }
        }else{
            Node<T> back = this.tail;
            if(currentElement.getValue() == element){
                Node<T> next = currentElement.getNext();
                this.head = next;
                next.setPrevious(null);
                this.size--;
            }else if(back.getValue() == element){
                Node<T> previous = back.getPrevious();
                this.tail = previous;
                previous.setNext(null);
                this.size--;
            }else{
                while(currentElement != null){
                    if(currentElement.getValue() == element){
                        Node<T> next = currentElement.getNext();
                        Node<T> previous = currentElement.getPrevious();
                        next.setPrevious(previous);
                        previous.setNext(next);
                        this.size--;
                        break;
                    }
                    currentElement = currentElement.getNext();
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    private class Node<T>{
        private T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
