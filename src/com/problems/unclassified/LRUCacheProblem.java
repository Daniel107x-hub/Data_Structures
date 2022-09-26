package com.problems.unclassified;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Map;

public class LRUCacheProblem {

    public static void main(String[] args){
        String[] instructions = {"LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"};
        int[][] data = {{3},{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},{1},{2},{3},{4},{5}};
        processInstructions(instructions, data);
    }

    public static void processInstructions(String[] instructions, int[][] data){
        LRUCache cache = new LRUCache(0);
        for(int i=0;i<instructions.length;i++){
            String instruction = instructions[i];
            int[] dat = data[i];
            switch (instruction){
                case "LRUCache":
                    cache = new LRUCache(dat[0]);
                    break;
                case "put":
                    cache.put(dat[0], dat[1]);
                    break;
                case "get":
                    System.out.println(cache.get(dat[0]));
                    break;
                default:
                    return;
            }
        }
    }

    private static class Element{
        public int key;
        public int value;
        public Element next;
        public Element prev;

        public Element(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class List{
        public Element head;
        public Element tail;

        public List() {}

        public boolean isEmpty(){
            return this.head == null && this.tail == null;
        }

        public void push(Element e){
            if(this.isEmpty()){
                this.head = e;
                this.tail = e;
                return;
            }
            e.next = this.head;
            this.head.prev = e;
            this.head = e;
        }

        public Element pop(){
            if(this.isEmpty()){
                return null;
            }else if(this.head == this.tail){
                Element e = this.head;
                this.head = null;
                this.tail = null;
                return e;
            }
            Element e = this.tail;
            Element prev = e.prev;
            prev.next = null;
            e.prev = null;
            this.tail = prev;
            return e;
        }

        public void repush(Element e){
            if(this.head == e) return;
            Element prev = e.prev;
            Element next = e.next;
            prev.next = next;
            if(next != null) next.prev = prev;
            e.prev = null;
            e.next = null;
            if(this.tail == e) this.tail = prev;
            this.push(e);
        }
    }

    private static class LRUCache{
        private int maxCapacity;
        private int elements;
        private List list;
        private Map<Integer, Element> map;

        public LRUCache(int maxCapacity) {
            this.maxCapacity = maxCapacity;
            this.elements = 0;
            this.list = new List();
            this.map = new HashMap<>();
        }

        public int get(int key){
            if(!map.containsKey(key)) return -1;
            Element e = map.get(key);
            this.list.repush(e);
            return e.value;
        }

        public void put(int key, int value){
            if(this.map.containsKey(key)){
                Element e = this.map.get(key);
                e.value = value;
                this.list.repush(e);
                return;
            }
            if(this.elements == this.maxCapacity){
                Element last = list.pop();
                if(last!=null) {
                    map.remove(last.key);
                    this.elements--;
                }
            }
            Element newElement = new Element(key, value);
            this.list.push(newElement);
            this.map.put(key, newElement);
            this.elements++;
        }
    }
}
