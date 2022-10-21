package com.problems.list;

import java.util.List;

public class MiddleLinkedList {
    public static void main(String args[]){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(middleNode(head).val);
    }

    private static int countNodes(ListNode head){
        int nodes = 0;
        while(head != null){
            nodes++;
            head = head.next;
        }
        return nodes;
    }

    private static ListNode middleNode(ListNode head){
        if(head == null) return head;
        int nodes = countNodes(head);
        int middle = nodes /2 + 1;
        while(middle > 1 && head != null){
            middle--;
            head = head.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
