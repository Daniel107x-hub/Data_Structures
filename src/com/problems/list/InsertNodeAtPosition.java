package com.problems.list;

import java.util.Scanner;

public class InsertNodeAtPosition {
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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(position == 0){
            newNode.next = head;
            return newNode;
        }
        SinglyLinkedListNode previousNode = head;
        SinglyLinkedListNode nextNode = previousNode.next;
        for(int i=1;i<position;i++){
            previousNode = nextNode;
            nextNode = previousNode.next;
        }
        previousNode.next = newNode;
        newNode.next = nextNode;
        return head;
    }

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        int elements = scanner.nextInt();
        for(int i=0;i<elements;i++){
            int element = scanner.nextInt();
            list.insertNode(element);
        }
        int data = scanner.nextInt();
        int position = scanner.nextInt();
        SinglyLinkedListNode head = insertNodeAtPosition(list.head, data, position);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
