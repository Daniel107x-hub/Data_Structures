package com.problems.list;

import java.util.Scanner;

public class DeleteNodeAtPosition {
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

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position){
        if(position == 0){
            llist = llist.next;
            return llist;
        }
        SinglyLinkedListNode previousNode = llist;
        SinglyLinkedListNode nextNode = previousNode.next;
        for(int i=1;i<position;i++){
            previousNode = nextNode;
            nextNode = previousNode.next;
        }
        previousNode.next = nextNode.next;
        return llist;
    }

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        int elements = scanner.nextInt();
        for(int i=0;i<elements;i++){
            int element = scanner.nextInt();
            list.insertNode(element);
        }
        int position = scanner.nextInt();
        SinglyLinkedListNode head = deleteNode(list.head, position);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
