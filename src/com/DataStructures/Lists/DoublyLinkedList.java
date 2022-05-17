package com.DataStructures.Lists;

public class DoublyLinkedList<T> implements IList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public boolean add(T element) {
        Node<T> node = new Node<>(element);
        if(this.head == null || this.tail == null){
            this.head = node;
            this.tail = node;
        }else{
            Node<T> currentHead = this.head;
            node.setNext(currentHead);
            currentHead.setPrev(node);
            this.head = node;
        }
        this.size++;
        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size){
            return null;
        }
        int currentIndex = 0;
        Node<T> node = this.tail;
        while(currentIndex < index){
            node = node.getPrev();
            currentIndex++;
        }
        return node.getValue();
    }

    @Override
    public boolean remove(int index) {
        if(index < 0 || index >= this.size){
            return false;
        }
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            int currentIndex = 0;
            Node<T> node = this.tail;
            while(currentIndex < index){
                node = node.getPrev();
                currentIndex++;
            }
            Node<T> previousNode = node.getPrev();
            Node<T> nextNode = node.getNext();
            if(previousNode == null){
                this.head = nextNode;
            }else if(nextNode == null){
                this.tail = previousNode;
            }else{
                previousNode.setNext(nextNode);
                nextNode.setPrev(previousNode);
            }
        }
        this.size--;
        return true;
    }

    @Override
    public boolean set(int index, T newElement) {
        if(index < 0 || index >= this.size){
            return false;
        }
        int currentIndex = 0;
        Node<T> node = this.tail;
        while(currentIndex < index){
            node = node.getPrev();
            currentIndex++;
        }
        node.setValue(newElement);
        return true;
    }

    public int getSize() {
        return size;
    }

    private class Node<T>{
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
