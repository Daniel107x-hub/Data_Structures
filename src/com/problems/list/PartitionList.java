package com.problems.list;

public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(5, new ListNode(2)))))));
        head = partition(head, 3);
        System.out.println(head);
    }

    public static ListNode partition(ListNode head, int x){
        if(head == null) return head;
        ListNode left = head;
        while(left.val < x && left.next != null && left.next.val < x){
            left = left.next;
        }
        ListNode right = left;
        while(right != null && right.next != null){
            if(right.next.val < x){
                ListNode node = right.next;
                right.next = right.next.next;
                if(left.val >= x && left == head){
                    node.next = left;
                    head = node;
                }else{
                    node.next = left.next;
                    left.next = node;
                }
                left = node;
            } else right = right.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            if(this.next != null) sb.append(" -> ").append(this.next);
            return sb.toString();
        }
    }
}
