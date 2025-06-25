package leetcode;

import java.util.*;

public class DesignAddAndSearchWord {
    public static void main(String[] args) {
        WordDictionary d = new WordDictionary();
        d.addWord("at");
        d.addWord("and");
        d.addWord("an");
        d.addWord("add");
        System.out.println(d.search("a"));
        System.out.println(d.search(".at"));
        d.addWord("bat");
        System.out.println(d.search(".at"));
        System.out.println(d.search("an."));
        System.out.println(d.search("a.d."));
        System.out.println(d.search("b."));
        System.out.println(d.search("a.d"));
        System.out.println(d.search("."));
    }

    static class WordDictionary {
        Node root;
        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node current = this.root;
            for(char c : word.toCharArray()){
                if(current.map.containsKey(c)) current = current.map.get(c);
                else{
                    Node node = new Node(c);
                    current.map.put(c, node);
                    current = node;
                }
            }
            current.isEnding = true;
        }

        public boolean search(String word) {
            Queue<Node> q = new LinkedList<Node>();
            q.offer(root);
            for(char c : word.toCharArray()){
                int levelSize = q.size();
                while(levelSize > 0){
                    Node node = q.poll();
                    if(node == null) return false;
                    if(c == '.'){
                        q.addAll(node.map.values());
                    }else{
                        if(node.map.containsKey(c)) q.offer(node.map.get(c));
                    }
                    levelSize--;
                }
            }
            return !q.isEmpty() && q.stream().anyMatch((Node node) -> node.isEnding);
        }
    }

    static class Node {
        public char val;
        public boolean isEnding;
        public Map<Character, Node> map;
        public Node(){
            map = new HashMap<>();
        }
        public Node(char c){
            this();
            this.val = c;
        }
    }
}
