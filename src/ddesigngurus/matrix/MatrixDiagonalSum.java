package ddesigngurus.matrix;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        if(mat.length == 1) return mat[0][0];
        int totalSum = 0;  // Initialize the total sum
        int ltr = 0;
        int rtl = mat.length - 1;
        for(int[] row : mat){
            totalSum += row[ltr];
            if(ltr != rtl) totalSum += row[rtl];
            ltr++;
            rtl--;
        }
        return totalSum;  // Return the calculated total sum
    }
}
