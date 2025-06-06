package leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 10));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
        int left = 0;
        int right = matrix.length - 1;
        while(left < right - 1){
            int middle = (left + right) / 2;
            if(target <= matrix[middle][0]) right = middle;
            else left = middle;
        }
        int row = -1;
        if(target >= matrix[left][0] && target < matrix[right][0]) row = left;
        if(target >= matrix[right][0] && target <= matrix[right][matrix[0].length - 1]) row =  right;
        if(row == -1) return false;
        left = 0;
        right = matrix[0].length - 1;
        while(left < right){
            int middle = (left + right) / 2;
            if(target <= matrix[row][middle]) right = middle;
            else left = middle + 1;
        }
        return matrix[row][left] == target;
    }
}
