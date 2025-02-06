package designgurus.matrix;

import java.util.LinkedList;
import java.util.List;

public class RowWithMaximumOnes {
    public static void main(String[] args) {
        int[][] mat = {{1, 0}, {1, 1}, {0, 1}};
        for(int num : findMaxOnesRow(mat)) System.out.println(num);
    }

    public static int[] findMaxOnesRow(int[][] mat) {
        int[] max = {-1, -1};
        for(int i = 0 ; i < mat.length ; i++){
            int sum = 0;
            for(int bit : mat[i]) sum += bit;
            if(sum > max[1]){
                max[0] = i;
                max[1] = sum;
            }
        }
        return max;
    }
}

// BGP