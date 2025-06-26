package leetcode;

import java.util.Arrays;

public class MinNumberOfTaps {
    public static void main(String[] args) {
        int[] ranges = {0, 0, 0, 0};
        System.out.println(minTaps(3, ranges));
    }

    public static int minTaps(int n, int[] ranges){
        final int INF = (int) 1e9;
        int[] g = new int[n + 1];
        Arrays.fill(g, INF);
        g[0] = 0;
        for(int i = 0 ; i <= n ; i++){
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            for(int j = start ; j <= end ; j++){
                g[j] = Math.min(g[start] + 1, g[j]);
            }
        }
        return g[n] == INF ? -1 : g[n];
    }
}
