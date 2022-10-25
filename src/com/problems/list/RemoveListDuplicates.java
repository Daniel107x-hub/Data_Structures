package com.problems.list;

public class RemoveListDuplicates {
 public static void main(String[] args){
  ListNode head = new ListNode(1, new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(3)))));
  head = deleteDuplicates(head);
  while(head != null){
   System.out.println(head.val);
   head = head.next;
  }
 }

 public static ListNode deleteDuplicates(ListNode head){
  ListNode current = head;
  while(current != null && current.next != null){
   if(current.val == current.next.val){
    current.next = current.next.next;
   }else {
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
