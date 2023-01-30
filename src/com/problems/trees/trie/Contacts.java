package com.problems.trees.trie;

import java.util.*;

public class Contacts {
    public static void main(String[] args) {
        List<List<String>> commands = new ArrayList<>();
        commands.add(Arrays.asList("add", "s"));
        commands.add(Arrays.asList("add", "ss"));
        commands.add(Arrays.asList("add", "sss"));
        commands.add(Arrays.asList("add", "ssss"));
        commands.add(Arrays.asList("add", "sssss"));
        commands.add(Arrays.asList("find", "s"));
        commands.add(Arrays.asList("find", "ss"));
        commands.add(Arrays.asList("find", "sss"));
        commands.add(Arrays.asList("find", "ssss"));
        commands.add(Arrays.asList("find", "sssss"));
        commands.add(Arrays.asList("find", "ssssss"));
        List<Integer> result = contacts(commands);
        for(int num : result){
            System.out.println(num);
        }
    }

    public static List<Integer> contacts(List<List<String>> queries){
        Trie trie = new Trie();
        List<Integer> counts = new ArrayList<>();
        for(List<String> query : queries){
            if("add".equals(query.get(0))){
                trie.add(query.get(1));
            }else if("find".equals(query.get(0))){
                int results = trie.findCount(query.get(1));
                counts.add(results);
            }
        }
        return counts;
    }

    public static class Trie{
        Node root;

        public Trie() {
        }

        public void add(String string){
            if(string.isEmpty()) return;
            if(root == null) root = new Node();
            Node current = root;
            Map<Character, Node> children = current.children;
            for(char c : string.toCharArray()){
                current.count++; // Store count within node, so each node knows how many words are below it
                current = children.get(c);
                if(current == null){
                    current = new Node(c);
                    children.put(c, current);
                }
                children = current.children;
            }
            current.count++; // Need to count this node as a final node
            current.isFinal = true;
        }

        public int findCount(String partial){
            Node current = root;
            int results = 0;
            if(partial.isEmpty() || current == null) return results;
            for(char c : partial.toCharArray()){
                current = current.children.get(c);
                if(current == null) return results;
            }
            return current.count;
        }

        public List<String> find(String partial){
            Node current = root;
            List<String> results = new ArrayList<>();
            if(partial.isEmpty() || current == null) return results;
            StringBuilder prefix = new StringBuilder();
            for(char c : partial.toCharArray()){
                Map<Character, Node> children = current.children;
                if(!children.containsKey(c)) return results;
                current = children.get(c);
                prefix.append(c);
            }
            searchWords(current, results, prefix);
            return results;
        }

        public boolean isEmpty(){
            return root == null;
        }

        private void searchWords(Node current, List<String> results, StringBuilder prefix){
            if(current == null) return;
            if(current.isFinal) results.add(prefix.toString());
            Map<Character, Node> children = current.children;
            for(char c : children.keySet()){
                prefix.append(c);
                searchWords(children.get(c), results, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static class Node{
        char value;
        boolean isFinal;
        int count;
        Map<Character, Node> children;

        public Node() {
            this.children = new HashMap<>();
        }

        public Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        public Node(char value, boolean isFinal) {
            this.value = value;
            this.isFinal = isFinal;
            this.children = new HashMap<>();
        }
    }
}
