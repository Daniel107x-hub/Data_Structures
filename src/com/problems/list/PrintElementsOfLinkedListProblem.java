package com.problems.list;

import java.util.Scanner;

public class PrintElementsOfLinkedListProblem {

    private static final Scanner scanner = new Scanner(System.in);
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void main(String[] args){
        int numbers = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i=0;i<numbers;i++){
            list.insertNode(scanner.nextInt());
        }
        printLinkedList(list.head);
    }

    public static void printLinkedList(SinglyLinkedListNode node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        printLinkedList(node.next);
    }


}
