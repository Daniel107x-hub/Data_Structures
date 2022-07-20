package com.problems.list;

public class SumListsInorder {
    private static class LinkedList{
        private Node head;
        private int size;

        public void add(int data){
            Node newNode = new Node(data);
            this.size++;
            if(this.head == null){
                this.head = newNode;
                return;
            }
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

        public void addFirst(int data){
            this.size++;
            Node newNode = new Node(data);
            if(this.head == null){
                this.head = newNode;
                return;
            }
            newNode.next = this.head;
            this.head = newNode;
        }

        @Override
        public String toString() {
            Node current = this.head;
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            while(current != null){
                sb.append(current.data);
                sb.append(' ');
                current = current.next;
            }
            sb.append(']');
            return sb.toString();
        }
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static LinkedList adjustSize(LinkedList l, int size){
        LinkedList result = new LinkedList();
        int originalSize = l.size;
        for(int i=0;i<size - originalSize;i++){
            result.add(0);
        }
        Node current = l.head;
        while(current != null){
            result.add(current.data);
            current = current.next;
        }
        return result;
    }

    public static LinkedList sumLists(LinkedList l1, LinkedList l2){
        if(l1.size < l2.size){
            l1 = adjustSize(l1, l2.size);
        }else if(l2.size < l1.size){
            l2 = adjustSize(l2, l1.size);
        }
        LinkedList result = new LinkedList();
        int first = sumLists(l1.head, l2.head, result);
        if(first > 0) {
            result.addFirst(first);
        }
        return result;
    }

    public static int sumLists(Node l1, Node l2, LinkedList result) {
        int sum = 0;
        if(l1 == null && l2 == null){
            return sum;
        }
        if (l1.next == null && l2.next == null) {
            sum = l1.data + l2.data;
            result.addFirst(sum % 10);
            return sum / 10;
        }
        int carry = sumLists(l1.next, l2.next, result);
        sum = l1.data + l2.data + carry;
        result.addFirst(sum % 10);
        return sum / 10;
    }

    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.add(6);
        l1.add(1);
        l1.add(7);
        l2.add(8);
        l2.add(1);
        l2.add(8);
        LinkedList result = sumLists(l1, l2);
        System.out.println(result);
    }
}
