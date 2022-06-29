package com.problems.list;

import java.util.Scanner;
import java.util.Stack;

public class ReverseLinkedList {
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

    private static final Scanner scanner = new Scanner(System.in);

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist){
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedList list = new SinglyLinkedList();
        while(llist != null){
            stack.push(llist.data);
            llist = llist.next;
        }
        while(!stack.empty()){
            int element = stack.pop();
            list.insertNode(element);
        }
        return list.head;
    }

    public static void main(String[] args){
        int testCases = scanner.nextInt();
        for(int i=0;i<testCases;i++){
            int elements = scanner.nextInt();
            SinglyLinkedList list = new SinglyLinkedList();
            for(int j=0;j<elements;j++){
                int element = scanner.nextInt();
                list.insertNode(element);
            }
            SinglyLinkedListNode head = reverse(list.head);
            while(head != null){
                System.out.println(head.data);
                head = head.next;
            }
        }
    }


}
