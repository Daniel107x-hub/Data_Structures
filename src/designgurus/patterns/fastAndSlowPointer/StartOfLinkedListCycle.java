package designgurus.patterns.fastAndSlowPointer;

import designgurus.common.ListNode;

/*
    This problem is mainly based on first finding the length of the cycle
    using fast & slow pointers and then, use that as an offset.
    Two pointers will meet after traversing the offset quantity of nodes again,
    and that's where the cycle starts.

    Let's suppose a linked list where the cycle has length b, and the part from the head to the cycle is a.
    The total length from the head to the beginning of the cycle is a + b
    If we start with a pointer at the head, another one at position b from the head, after both traverse a items, they will
    be at position a, a+b, which is the beginning of the cycle.

 */
public class StartOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode cycle = new ListNode(4);
        cycle.next = new ListNode(5, new ListNode(6, cycle));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, cycle)));
        ListNode cycleStart = findCycleStart(head);
        System.out.print(cycleStart.val);
    }

    private static ListNode findCycleStart(ListNode head)
    {
        int cycleLength = getCycleLength(head);
        ListNode p1 = head;
        ListNode p2 = head;
        while(cycleLength > 0){
            p2 = p2.next;
            cycleLength--;
        }
        while(p1 != p2){
            p1  = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static int  getCycleLength(ListNode head){
        int counter = 1;
        if(head == head.next) return counter;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        while(slow != fast){
            slow = slow.next;
            counter++;
        }
        return counter;
    }
}
