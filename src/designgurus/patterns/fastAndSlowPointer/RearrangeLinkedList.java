package designgurus.patterns.fastAndSlowPointer;

import designgurus.common.ListNode;

public class RearrangeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode (3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(head);
        System.out.println(reorder(head));
    }

    private static ListNode reorder(ListNode head){
        if(head ==  null || head.next == null || head.next.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // We reached the middle of the list with P1
        ListNode prev = null;
        while(p1.next != null){
            ListNode next = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = next;
        }
        p1.next = prev;
        // We reversed the last half
        p2 = head;
        while(p1 != null && p2 != null){
            ListNode next = p1.next;
            p1.next = p2.next;
            p2.next = p1;
            p2 = p1.next;
            p1 = next;
        }
        // Finally we insert the last half in the proper order
        return head;
    }
}
