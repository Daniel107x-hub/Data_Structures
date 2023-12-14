package com.problems.list;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode toRemove = new ListNode(5);
        ListNode head = new ListNode(4).setNext(toRemove.setNext(new ListNode(1).setNext(new ListNode(9))));
        System.out.println("Before delete:");
        System.out.println(head);
        deleteNode(toRemove);
        System.out.println("After delete:");
        System.out.println(head);
    }

    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            if(this.next != null) sb.append(" -> ").append(this.next);
            return sb.toString();
        }
    }
}
