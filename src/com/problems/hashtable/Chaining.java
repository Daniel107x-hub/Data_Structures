package com.problems.hashtable;

import java.util.Scanner;

public class Chaining {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        tests();
    }

    public static void tests(){
        String s = "hello";
        HashTable table = new HashTable(10);
        table.add(s);
    }

    private static class HashTable{
        private final int m;
        private List[] buckets;
        private static final int P = 1000000007;
        private static final int X = 263;

        public HashTable(int m) {
            this.m = m;
            this.buckets = new List[m];
        }

        private int hash(String s){
            Long hashCode = 0L;
            for(int i=s.length()-1;i>=0;i--){
                int charCode = s.charAt(i);
                hashCode = (hashCode * X + charCode) % P;
            }
            return hashCode.intValue();
        }

        public void add(String s){
            int hashCode = hash(s) % m;
            List list = buckets[hashCode];
            if(list != null && list.contains(s)) return;
            if(list == null){
                list = new List();
                buckets[hashCode] = list;
            }
            list.add(s);
        }

        public void del(String s){
            int hashCode = hash(s) % m;
            List list = buckets[hashCode];
            if(list.isEmpty()) return;
            list.remove(s);
        }

        public void find(String s){
            int hashCode = hash(s) % m;
            List list = buckets[hashCode];
            if(list.contains(s)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

        public void check(int i){
            List list = buckets[i];
            System.out.println(list);
        }
    }

    private static class List{
        private Node head;
        private Node tail;

        public List() {}

        public boolean contains(String s){
            if(this.isEmpty()) return false;
            Node current = this.head;
            while(current != null){
                if(current.getValue().equals(s)){
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }

        public void add(String s){
            Node newNode = new Node(s);
            if(!this.isEmpty()){
                newNode.setNext(this.head);
                this.head.setPrevious(newNode);
            }else{
                this.tail = newNode;
            }
            this.head = newNode;
        }

        public boolean isEmpty(){
            return this.head == null && this.tail == null;
        }

        public void remove(String s){
            if(this.isEmpty()) return;
            if(this.head == this.tail){ //Single element case
                this.head = null;
                this.tail = null;
            }else if(this.head.getValue().equals(s)){ //Head case
                this.head = this.head.getNext();
            }else if(this.tail.getValue().equals(s)) { // Tail case
                this.tail = this.tail.getPrevious();
            }else{
                Node current = this.head;
                while(current != null){
                    if(current.getValue().equals(s)){
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                        return;
                    }
                    current = current.getNext();
                }
            }
        }

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            if(!this.isEmpty()){
                Node current = this.head;
                while(current != null){
                    stringBuilder.append(current.getValue());
                    stringBuilder.append(" ");
                    current = current.getNext();
                }
            }
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
    }

    private static class Node{
        private String value;
        private Node next;
        private Node previous;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
