package com.problems.list;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOf2Lists {
    public static void main(String[] args) {
        ListNode common = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode headA = new ListNode(10, new ListNode(11, new ListNode(12, common)));
        ListNode headB = new ListNode(10, new ListNode(21, common));
        System.out.println(common);
        System.out.println(headA);
        System.out.println(headB);
        System.out.println(getIntersectionByDifference(headA, headB));
    }

    private static ListNode getIntersection(ListNode headA, ListNode headB){
        Set<ListNode> nodeSet = addNodes(headA);
        while(headB != null){
            if(nodeSet.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    private static Set<ListNode> addNodes(ListNode head){
        Set<ListNode> nodeSet = new HashSet<>();
        while(head != null){
            nodeSet.add(head);
            head = head.next;
        }
        return nodeSet;
    }

    private static ListNode getIntersectionByDifference(ListNode headA, ListNode headB){
        int listASize = getSize(headA);
        int listBSize = getSize(headB);
        int difference = Math.abs(listASize - listBSize);
        if(listASize > listBSize) headA = advanceNNodes(headA, difference);
        else if(listBSize > listASize) headB = advanceNNodes(headB, difference);
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    private static ListNode advanceNNodes(ListNode head, int nodes){
        while(nodes > 0){
            head = head.next;
            nodes--;
        }
        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      ListNode(int x, ListNode next){
          val = x;
          this.next = next;
      }

    @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            if(this.next != null) sb.append("->").append(next);
            return sb.toString();
        }
    }
}
