package com.problems.list;

public class LinkedListContruction {
    public static void main(String[] args) {

    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            this.head = node;
        }

        public void setTail(Node node) {
            this.tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if(this.head == node){
                this.head = nodeToInsert;
            }else{
                Node prev = node.prev;
                prev.next = nodeToInsert;
                nodeToInsert.prev = prev;
            }
            nodeToInsert.next = node;
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if(this.tail == node){
                this.tail = nodeToInsert;
            }else{
                Node next = node.next;
                nodeToInsert.next = next;
                next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
            nodeToInsert.prev = node;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            Node current = this.head;
            while(position > 1){
                current = current.next;
                if(current == null) return;
                position--;
            }
            this.insertBefore(current, nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
        }

        public void remove(Node node) {
            if(this.head == node) this.head = node.next;
            if(this.tail == node) this.tail = node.prev;
//            Node prev = node.
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
