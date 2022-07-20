package com.problems.list;

import java.util.Iterator;
import java.util.LinkedList;

public class SumLists {
    public static LinkedList<Integer> sumLists(LinkedList<Integer> l1, LinkedList<Integer> l2){
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        Iterator<Integer> it1 = l1.iterator();
        Iterator<Integer> it2 = l2.iterator();
        while(it1.hasNext() || it2.hasNext()){
            int sum = 0;
            if(it1.hasNext()){
                sum += it1.next();
            }
            if(it2.hasNext()){
                sum += it2.next();
            }
            sum += carry;
            result.add(sum % 10);
            carry = sum / 10;
        }
        return result;
    }

    public static void main(String[] args){
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(7);
        l1.add(1);
        l1.add(6);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(9);
        l2.add(2);
        System.out.println(sumLists(l1, l2));
    }
}
