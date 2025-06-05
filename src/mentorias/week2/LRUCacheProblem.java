package mentorias.week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LRUCacheProblem {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    static class LRUCache{
        private int maxSize;
        private Map<Integer, Node> map;
        private List list;

        public LRUCache(int capacity){
            this.maxSize = capacity;
            this.map = new HashMap<>();
            this.list = new List();
        }

        public int get(int key){
            Node node = map.getOrDefault(key, null);
            if(node == null) return -1;
            list.remove(node);
            list.push(node);
            return node.value;
        }

        public void put(int key, int value){
            Node node = map.getOrDefault(key, null);
            if(node == null){
                node = new Node(key, value);
                if(list.size == maxSize ){
                    Node removed = list.pop();
                    map.remove(removed.key);
                }
            }
            else{
                node.value = value;
                list.remove(node);
            }
            map.put(key, node);
            list.push(node);
        }
    }

    static class List {
        public Node head;
        public Node tail;
        public int size = 0;

        public void push(Node node){
            if(head == null){
                head = node;
                tail = node;
            }else{
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        public Node pop(){
            if(size == 0) return null;
            Node node = tail;
            if(size == 1){
                head = null;
                tail = null;
            }else{
                tail = node.prev;
                tail.next = null;
            }
            size--;
            node.next = null;
            node.prev = null;
            return node;
        }

        public void remove(Node node){
            if(size == 0) return;
            if(size == 1){
                head = null;
                tail = null;
            }else if(node == head){
                head = node.next;
                head.prev = null;
            }else if(node == tail){
                tail = node.prev;
                tail.next = null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
            node.next = null;
            node.prev = null;
        }
    }

    static class Node {
        private int key;
        private int value;
        public Node next;
        public Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
