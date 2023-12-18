package com.problems.list;

public class RemoveFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(head);
        System.out.println(removeNthFromEndv2(head, 2));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(this.val) + (this.next != null ? " -> " + this.next.toString() : "");
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        int m = getListSize(head);
        return removeNth(head, m - n);
    }

    public static int getListSize(ListNode head){
        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }
        return size;
    }

    public static ListNode removeNth(ListNode head, int n){
        if(n == 0){
            head = head.next;
        }
        else{
            ListNode curr = head;
            while(n > 1){
                curr = curr.next;
                n--;
            }
            curr.next = curr.next.next;
        }
        return head;
    }

    public static ListNode removeNthFromEndv2(ListNode head, int n){
        if(head == null) return null;
        ListNode left = null;
        ListNode right = head;
        while(n > 0){
            right = right.next;
            n--;
        }
        left = head;
        if(right == null) return left.next;
        while(right.next != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
}
