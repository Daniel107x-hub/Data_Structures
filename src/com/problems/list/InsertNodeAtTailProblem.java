package com.problems.list;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertNodeAtTailProblem {

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

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node){
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // Complete the insertNodeAtTail function below.
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode currentNode = head;
        if(currentNode == null){
            head = newNode;
        }else{
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        return head;
    }

    public static void main(String[] args){
        int numbers = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i=0;i<numbers;i++){
            int data = scanner.nextInt();
            list.head = insertNodeAtTail(list.head, data);
        }
        printSinglyLinkedList(list.head);
    }
}
