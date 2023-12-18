package com.problems.list;

public class SumOfLinkedLists {
    public static void main(String[] args) {

    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList result = null;
        LinkedList current = null;
        int carry = 0;
        while(linkedListOne != null || linkedListTwo != null){
            int sum = (linkedListOne != null ? linkedListOne.value : 0) +
                    (linkedListTwo != null ? linkedListTwo.value : 0) +
                    carry;
            int value = sum % 10;
            carry = Math.floorDiv(sum, 10);
            if(result == null){
                result = new LinkedList(value);
                current = result;
            }else{
                current.next = new LinkedList(value);
                current = current.next;
            }
            if(linkedListOne != null) linkedListOne = linkedListOne.next;
            if(linkedListTwo != null) linkedListTwo = linkedListTwo.next;
        }
        if(carry > 0){
            current.next = new LinkedList(carry);
        }
        return result;
    }
}
