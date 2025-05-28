package mentorias.week1;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] test = {
                { '1', '1', '1', '1', '0'},
                { '1', '1', '0', '1', '0'},
                { '1', '1', '0', '0', '0'},
                { '0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(test));
    }

    public static int numIslands(char[][] grid){
        int result = 0;
        for(int row = 0 ; row < grid.length ; row++){
            for(int col = 0 ; col < grid[0].length ; col++){
                if(grid[row][col] == '0') continue;
                result++;
                traverseIsland(grid, row, col);
            }
        }
        return result;
    }

    private static void traverseIsland(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if(grid[row][col] != '1') return;
        grid[row][col] = '0';
        traverseIsland(grid, row - 1, col);
        traverseIsland(grid, row + 1, col);
        traverseIsland(grid, row, col - 1);
        traverseIsland(grid, row, col + 1);
    }
}
