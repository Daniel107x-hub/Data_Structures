package com.DataStructures.Lists;

public class LinkedList<T> implements IList<T>{

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean add(T element) {
        Node<T> node = new Node<>(element);
        node.setNext(this.head);
        this.head = node;
        this.size++;
        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size){
            return null;
        }
        Node<T> node = this.head;
        int currentIndex = this.size - 1;
        while(currentIndex != index){
            node = node.getNext();
            currentIndex--;
        }
        return node.getValue();
    }

    @Override
    public boolean remove(int index) {
        if(index < 0 || index >= this.size){
            return false;
        }
        Node<T> node = this.head;
        if(index == this.size - 1){
            this.head = node.getNext();
        }else {
            int currentIndex = this.size - 1;
            while (currentIndex != index + 1) {
                node = node.getNext();
                currentIndex--;
            }
            Node<T> nextNode = node.getNext();
            node.setNext(nextNode.getNext());
        }
        this.size--;
        return true;
    }

    @Override
    public boolean set(int index, T newElement) {
        if(index < 0 || index >= this.size){
            return false;
        }
        Node<T> node = this.head;
        int currentIndex = this.size - 1;
        while(currentIndex != index){
            node = node.getNext();
            currentIndex--;
        }
        node.setValue(newElement);
        return true;
    }



    @Override
    public String toString() {
        Node<T> node = this.head;
        StringBuilder stringBuilder = new StringBuilder("List: [");
        while(node != null){
            stringBuilder.append(node.getValue());
            if(node.getNext() != null){
                stringBuilder.append(", ");
            }
            node = node.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getSize() {
        return size;
    }

    private class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
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
    }
}
