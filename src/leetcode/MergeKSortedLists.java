package leetcode;

import designgurus.common.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for(ListNode list : lists){
            if(list!=null) pq.add(list);
        }
        ListNode result = null;
        ListNode tail = null;
        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            ListNode next = current.next;
            current.next = null;
            if(result == null){
                result = current;
                tail = result;
            }else {
                tail.next = current;
                tail = current;
            }
            if(next != null) pq.add(next);
        }
        return result;
    }
}
