package com.problems.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CycleDetectionProblem {
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
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        SinglyLinkedListNode first = list.head;
        SinglyLinkedListNode last = list.tail;
        last.next = first;
        boolean result = hasCycle(list.head);
        System.out.println(result);
    }

    private static boolean hasCycle(SinglyLinkedListNode head){
        Set<SinglyLinkedListNode> set = new HashSet<>();
        SinglyLinkedListNode current = head;
        while(current != null){
            boolean hasNodeShown = set.contains(current);
            if(hasNodeShown){
                return true;
            }
            set.add(current);
            current =  current.next;
        }
        return false;
    }
}
