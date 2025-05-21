package designgurus.patterns.fastAndSlowPointer;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode cycle = new ListNode(3);
        cycle.next = new ListNode(4, new ListNode(5, new ListNode(6, cycle)));
        ListNode head = new ListNode(1, new ListNode(2, cycle));
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode next){
            val = x;
            this.next = next;
        }
    }
}
