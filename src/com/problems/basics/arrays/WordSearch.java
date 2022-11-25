package com.problems.basics.arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'c','a','a'},{'a','a','a'},{'b','c','d'}};
        String word = "aab";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word){
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] wordArray = word.toCharArray();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(isWord(board, i, j, wordArray, 0, visited)) return true;
            }
        }
        return false;
    }

    public static boolean isWord(char[][] board, int row, int col, char[] word, int index,  boolean[][] visited){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] != word[index]) return false;
        if(visited[row][col]) return false;
        if(index == word.length - 1) return board[row][col] == word[index];
        visited[row][col] = true;
        if(isWord(board, row - 1, col, word, index + 1, visited) ||
                isWord(board, row, col + 1, word, index + 1, visited) ||
                isWord(board, row + 1, col, word, index + 1, visited) ||
                isWord(board, row, col - 1, word, index + 1, visited)) return true;
        visited[row][col] = false;
        return false;
    }
}
