package com.problems.list;

public class LinkedListCycle {

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode current = head.next;
        current.next = head;
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slower = head;
        ListNode faster = slower.next;
        while(slower.next != null && faster.next != null && faster.next.next != null){
            if(slower == faster) return true;
            slower = slower.next;
            faster = faster.next.next;
        }
        return false;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
    }
 }
}
