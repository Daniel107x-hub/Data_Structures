package com.datastructures.trees;

import java.util.Map;

public class TrieNode {
    private boolean isFinal;
    private Character value;
    Map<Character, TrieNode> children;

    public TrieNode(){}

    public TrieNode(Character value){
        this.value = value;
        this.isFinal = false;
    }

    public TrieNode(Character value, boolean isFinal){
        this(value);
        this.isFinal = isFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public TrieNode getChild(Character letter){
        return this.children.getOrDefault(letter, null);
    }
}
