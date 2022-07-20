package com.datastructures.trees;

import java.util.*;

public class Trie {
    private static final char FINAL_CHARACTER = '*';
    private TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        word = word.trim().toLowerCase();
        if(word.contains(" ")){
            throw new IllegalArgumentException("Unable to add more than 1 word per method call");
        }
        TrieNode current = this.root;
        Map<Character, TrieNode> children = current.getChildren();
        for(char letter: word.toCharArray()){
            children = current.getChildren();
            if(children == null){
                children = new HashMap<>();
                current.setChildren(children);
            }
            if(children.containsKey(letter)){
                current = children.get(letter);
                continue;
            }
            TrieNode newNode = new TrieNode(letter);
            children.put(letter, newNode);
            current = newNode;
        }
        children = current.getChildren();
        if(children == null){
            children = new HashMap<>();
            current.setChildren(children);
        }
        if(!children.containsKey('*')){
            TrieNode finalNode = new TrieNode(FINAL_CHARACTER, true);
            children.put(FINAL_CHARACTER, finalNode);
        }
    }

    public List<String> getWords(String prefix, int limit){
        prefix = prefix.trim().toLowerCase();
        if(prefix.contains(" ")){
            throw new IllegalArgumentException("Unable to search more than 1 prefix per method call");
        }
        List<String> words = new ArrayList<>();
        TrieNode current = this.root;
        for(char letter : prefix.toCharArray()){
            Map<Character, TrieNode> children = current.getChildren();
            if(children == null || !children.containsKey(letter)){
                return null;
            }
            current = children.get(letter);
        }
        Map<Character, TrieNode> children = current.getChildren();
        for(Character letter : children.keySet()){
            words.addAll(getWords(children.get(letter), limit, words, prefix));
        }
        return words;
    }

    public List<String> getWords(TrieNode node, int limit, List<String> words, String prefix){
        if(limit == words.size()) return Collections.EMPTY_LIST;
        words =  new ArrayList<>();
        if(node.isFinal()){
            words.add(prefix);
        }else{
            prefix = prefix + node.getValue();
            Map<Character, TrieNode> children = node.getChildren();
            for(Character letter : children.keySet()){
                words.addAll(getWords(children.get(letter), limit, words, prefix));
            }
        }
        return words;
    }
}

