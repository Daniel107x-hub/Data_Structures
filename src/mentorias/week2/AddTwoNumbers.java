package mentorias.week2;

import designgurus.common.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode result = null;
        ListNode tail = null;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            if(result == null){
                result = newNode;
                tail = result;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(tail == null) throw new IllegalArgumentException("At least 1 list doesn't contain elements");
        ListNode remainingItems = l1 == null ? l2 : l1;
        while(remainingItems != null){
            int sum = remainingItems.val + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            remainingItems = remainingItems.next;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return result;
    }
}
