package com.problems.list;

public class MergeSortedLists {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head = mergeTwoLists(list1, list2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = null;
        ListNode current = null;
        while(list1 != null && list2 != null){
            ListNode min;
            if(list1.val < list2.val){
                min = list1;
                list1 = list1.next;
            }else{
                min = list2;
                list2 = list2.next;
            }
            if(head == null){
                head = min;
                current = head;
            }else{
                current.next = min;
                current = current.next;
            }
        }
        if(list1 == null && list2 != null){
            current.next = list2;
        }else if(list1 != null){
            current.next = list1;
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
