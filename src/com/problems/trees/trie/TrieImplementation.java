package com.problems.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImplementation {

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("he"));
    }

    public static class Trie{
        private Node root;

        public Trie() {
            this.root = new Node('*');
        }

        public void insert(String word){
            Node current = root;
            for(char letter : word.toCharArray()){
                Map<Character, Node> children = current.getChildren();
                if(children == null){
                    children = new HashMap<>();
                    current.setChildren(children);
                }
                if(children.containsKey(letter)){
                    current = children.get(letter);
                }else {
                    Node newNode = new Node(letter);
                    children.put(letter, newNode);
                    current = newNode;
                }
            }
            current.setEnding(true);
        }

        public boolean search(String word){
            Node current = root;
            for(char letter : word.toCharArray()){
                Map<Character, Node> children = current.getChildren();
                if(children == null || !children.containsKey(letter)) return false;
                current = children.get(letter);
            }
            return current.isEnding();
        }

        public boolean startsWith(String prefix){
            Node current = root;
            for(char letter : prefix.toCharArray()){
                Map<Character, Node> children = current.getChildren();
                if(children == null || !children.containsKey(letter)) return false;
                current = children.get(letter);
            }
            return true;
        }
    }

    private static class Node{
        private boolean isEnding;
        private char key;
        private Map<Character, Node> children;

        public Node(char key) {
            this.key = key;
            this.isEnding = false;
        }

        public boolean isEnding() {
            return isEnding;
        }

        public void setEnding(boolean ending) {
            isEnding = ending;
        }

        public char getKey() {
            return key;
        }

        public void setKey(char key) {
            this.key = key;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, Node> children) {
            this.children = children;
        }
    }
}
