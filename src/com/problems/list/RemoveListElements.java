package com.problems.list;

public class RemoveListElements {
    public static void main(String[] args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        head = removeElements(head, 6);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val){

        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            if(current.val == val){
                if(prev == null){
                    head = head.next;
                    current = head;
                }else{
                    current = current.next;
                    prev.next = current;
                }
            }else{
                prev = current;
                current = current.next;
            }
        }
        return head;
    }


     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
