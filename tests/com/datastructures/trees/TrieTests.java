package com.datastructures.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TrieTests {
    @Test
    public void trieTest(){
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("hi");
        trie.insert("helP");
        trie.insert("works");
        System.out.println("Hello");
    }

    @Test
    public void testTrieGetWords(){
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("hi");
        trie.insert("helP");
        trie.insert("works");
        List<String> words = trie.getWords("h", 2);
        System.out.println("Hello");
    }
}
