package com.problems.list;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindrome(ListNode head){
        ListNode left = head;
        ListNode right = head;
        while(right.next != null && right.next.next != null){
            left = left.next;
            right = right.next.next;
        }
        if(left == right && left.next != null) return left.val == left.next.val; // 2 nodes case
        if(left == right) return true; // Single node case
        right = left.next;
        left.next = null;
        while(right.next != null){
            ListNode next = right.next;
            right.next = left;
            left = right;
            right = next;
        }
        right.next = left;
        left = head;
        while(left != right && left != null && right != null){
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
