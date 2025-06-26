package leetcode;

import java.util.*;

public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'n', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain", "eaten"};
        for(String s : findWordsTrie(board, words)){
            System.out.println(s);
        }
    }

    public static List<String> findWords(char[][] board, String[] words){
        Map<Character, List<String>> map = createWordsMap(words);
        Set<String> found = new HashSet<>();
        boolean[][] visited=  new boolean[board.length][board[0].length];
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[0].length ; col++){
                char c = board[row][col];
                List<String> list = map.getOrDefault(c, Collections.emptyList());
                if(list.isEmpty()) continue;
                for(String s : list){
                    if(found.contains(s)) continue;
                    boolean isWordPresent = searchWord(board, row, col, visited, s, 0);
                    if(isWordPresent){
                        found.add(s);
                    }
                }
            }
        }
        return found.stream().toList();
    }

    public static Map<Character, List<String>> createWordsMap(String[] words){
        Map<Character, List<String>> map = new HashMap<>();
        for(String s : words){
            char c = s.charAt(0);
            if(!map.containsKey(c)) map.put(c, new ArrayList<>());
            List<String> list = map.get(c);
            list.add(s);
        }
        return map;
    }

    public static boolean searchWord(char[][] board, int row, int col, boolean[][] visited, String word, int position){
        if(board[row][col] != word.charAt(position)) return false;
        if(position == word.length() - 1) return true;
        visited[row][col] = true;
        boolean exists = false;
        if(row > 0 && !visited[row - 1][col]) exists |= searchWord(board, row - 1, col, visited, word, position + 1);
        if(row < board.length - 1 && !visited[row + 1][col]) exists |= searchWord(board, row + 1, col, visited, word, position + 1);
        if(col > 0 && !visited[row][col - 1]) exists |= searchWord(board, row, col - 1, visited, word, position + 1);
        if(col < board[0].length - 1 && !visited[row][col + 1]) exists |= searchWord(board, row, col + 1, visited, word, position + 1);
        visited[row][col] = false;
        return exists;
    }

    public static List<String> findWordsTrie(char[][] board, String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode current = root;
            for(char c : w.toCharArray()){
                if(!current.children.containsKey(c)) current.children.put(c, new TrieNode(c));
                current = current.children.get(c);
            }
            current.isFinal = true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> results = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(int row = 0 ; row < board.length ; row ++){
            for(int col = 0 ; col < board[0].length ; col++){
                searchWords(board, row, col, visited, results, word, root);
            }
        }
        return results;
    }

    public static void searchWords(char[][] board, int row, int col, boolean[][] visited, List<String> results, StringBuilder word, TrieNode parent){
        char c = board[row][col];
        if(!parent.children.containsKey(c)) return;
        TrieNode current = parent.children.get(c);
        word.append(current.val);
        if(current.isFinal) {
            results.add(word.toString());
            current.isFinal = false;
        };
        visited[row][col] = true;
        if(row > 0 && !visited[row - 1][col]) searchWords(board, row - 1, col, visited, results, word, current);
        if(row < board.length - 1 && !visited[row + 1][col]) searchWords(board, row + 1, col, visited, results, word, current);
        if(col > 0 && !visited[row][col - 1]) searchWords(board, row, col - 1, visited, results, word, current);
        if(col < board[0].length - 1 && !visited[row][col + 1]) searchWords(board, row, col + 1, visited, results, word, current);
        visited[row][col] = false;
        word.deleteCharAt(word.length() - 1);
    }

    static class TrieNode {
        char val;
        boolean isFinal;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode(){};
        public TrieNode(char val){
            this.val = val;
        }
    }
}
