package com.problems.list;

public class RemoveDuplicatesList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, new LinkedList(1, new LinkedList(3, new LinkedList(4, new LinkedList(4, new LinkedList(4, new LinkedList(5, new LinkedList(5))))))));
        list = removeDuplicatesFromLinkedList(list);
        while(list != null){
            System.out.println(list.value);
            list = list.next;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        LinkedList head = linkedList;
        while(linkedList != null && linkedList.next != null){
            if(linkedList.value == linkedList.next.value){
                linkedList.next = linkedList.next.next;
                continue;
            }
            linkedList = linkedList.next;
        }
        return head;
    }
}
