package leetcode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCED"));
    }

    public static boolean exist(char[][] board, String word){
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[0].length ; col++){
                if(exist(board, word, visited, row, col, 0)) return true;
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, boolean[][] visited, int row, int col, int position){
        if(row > board.length || row < 0 || col > board[0].length || col < 0) return false;
        if(position == word.length() - 1 && board[row][col] == word.charAt(position)) return true;
        if(board[row][col] != word.charAt(position)) return false;
        visited[row][col] = true;
        boolean exists = false;
        if(row > 0 && !visited[row - 1][col]) exists |= exist(board, word, visited, row - 1, col, position + 1);
        if(row < board.length - 1 && !visited[row + 1][col]) exists |= exist(board, word, visited, row + 1, col, position + 1);
        if(col > 0 && !visited[row][col - 1]) exists |= exist(board, word, visited, row, col - 1, position + 1);
        if(col < board[0].length - 1 && !visited[row][col + 1]) exists |= exist(board, word, visited, row, col + 1, position + 1);
        if(exists) return true;
        visited[row][col] = false;
        return false;
    }
}
