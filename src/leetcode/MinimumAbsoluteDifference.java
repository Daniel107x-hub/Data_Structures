package leetcode;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int[][] grid = {
                {1, -2, 3},
                {2, 3, 5}
        };
        for(int[] row : minAbsDiff(grid, 2)){
            for(int e : row) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static int[][] minAbsDiff(int[][] grid, int k) {
        int[][] result = new int[grid.length - k + 1][grid[0].length - k + 1];
        for(int row = 0 ; row < grid.length - k + 1 ; row++){
            for(int col = 0 ; col < grid[0].length - k + 1 ; col++){
                result[row][col] = calculateMinAbsDiff(row, col, grid, k);
            }
        }
        return result;
    }

    public static int calculateMinAbsDiff(int sRow, int sCol, int[][] grid, int k){
        int minDiff = Integer.MAX_VALUE;
        boolean areAllElementsEqual = true;
        for(int row = sRow ; row < sRow + k ; row++){
            for(int col = sCol ; col < sCol + k ; col++){
                for(int nRow = sRow ; nRow < sRow + k ; nRow++){
                    for(int nCol = sCol ; nCol < sCol + k ; nCol++){
                        if (row == nRow && col == nCol) continue;
                        int current = grid[row][col];
                        int pair = grid[nRow][nCol];
                        areAllElementsEqual = areAllElementsEqual && current == pair;
                        if(current == pair) continue;
                        minDiff = Math.min(minDiff, Math.abs(current - pair));
                    }
                }
            }
        }
        if(areAllElementsEqual) minDiff = 0;
        return minDiff;
    }
}
