package com.problems.graphs;

import java.util.ArrayList;
import java.util.List;

public class CountLuck {
    private static final String IMPRESSED = "Impressed";
    private static final String OOPS = "Oops!";
    private static final char START_CHARACTER = 'M';
    private static final char END_CHARACTER = '*';
    private static final char TREE_CHARACTER = 'X';

    public static void main(String[] args) {
        List<String> input = List.of(
                ".X.X......X",
                ".X*.X.XXX.X",
                ".XX.X.XM...",
                "......XXXX."
        );
        System.out.println(countLuck(input, 3));
    }

    private static String countLuck(List<String> matrix, int k){
        int rows = matrix.size();
        int cols = matrix.get(0).length();
        char[][] m = new char[rows][cols];
        int[] start = new int[2];
        int[] end = new int[2];
        for(int i = 0 ; i < rows ; i++){
            String row = matrix.get(i);
            for(int j = 0 ; j < cols ; j++){
                m[i][j] = row.charAt(j);
                if(m[i][j] == START_CHARACTER){
                    start = new int[]{i, j};
                }
                if(m[i][j] == END_CHARACTER){
                    end = new int[]{i, j};
                }
            }
        }
        int result = countLuck(m, start, end, 0);
        if(result == k) return IMPRESSED;
        return OOPS;
    }

    private static int countLuck(char[][] matrix, int[] start, int[] end, int decisions){
        if(start[0] == end[0] && start[1] == end[1]) return decisions;
        matrix[start[0]][start[1]] = TREE_CHARACTER;
        List<int[]> options = getOptions(matrix, start);
        if(options.size() == 0) return -1;
        if(options.size() == 1) return countLuck(matrix, options.get(0), end, decisions);
        for(int[] option : options){
            int partialResult = countLuck(matrix, option, end, decisions + 1);
            if(partialResult > -1) return partialResult;
        }
        return -1;
    }

    private static List<int[]> getOptions(char[][] matrix, int[] position){
        List<int[]> options = new ArrayList<>();
        int row = position[0];
        int col = position[1];
        int[] left = col == 0 || matrix[row][col - 1] == TREE_CHARACTER ? null :  new int[]{row, col - 1};
        int[] right = col >= matrix[row].length - 1 || matrix[row][col + 1] == TREE_CHARACTER ? null : new int[]{row, col + 1};
        int[] top = row == 0 || matrix[row - 1][col] == TREE_CHARACTER ? null :  new int[]{row - 1, col};
        int[] bottom = row >= matrix.length - 1 || matrix[row + 1][col] == TREE_CHARACTER ? null : new int[]{row + 1, col};
        if(left != null) options.add(left);
        if(right != null) options.add(right);
        if(top != null) options.add(top);
        if(bottom != null) options.add(bottom);
        return options;
    }
}
