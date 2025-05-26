package designgurus.patterns.dp;
import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(minimumTotal(matrix));
    }

    public static int minimumTotal(List<List<Integer>> triangle){
        if(triangle.isEmpty()) return -1;
        for(int  i = triangle.size() - 2 ; i >= 0 ; i--){
            for(int j = i ; j >= 0 ; j--){
                int minCurrent = triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, minCurrent);
            }
        }
        return triangle.getFirst().getFirst();
    }
}
