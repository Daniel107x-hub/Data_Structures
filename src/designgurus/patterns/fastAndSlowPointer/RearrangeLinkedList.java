package designgurus.patterns.fastAndSlowPointer;

import designgurus.common.ListNode;

public class RearrangeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(reorder(head));
    }

    public static ListNode reorder(ListNode head){
        ListNode front = head;
        ListNode back = head;
        while(back != null && back.next != null){
            front = front.next;
            back = back.next.next;
        }
        back = front;
        front = head;
        back = reverse(back);
        while(front.next != null && back.next != null){
            ListNode nextLeft = front.next;
            ListNode nextRight = back.next;
            front.next = back;
            back.next = nextLeft;
            front = nextLeft;
            back = nextRight;
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
