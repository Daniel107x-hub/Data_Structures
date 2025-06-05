package mentorias.week2;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        System.out.println(longestDiverseStringPQ(1, 1, 7));
    }

    public static String longestDiverseString(int a, int b, int c) {
        return longestDiverseString(new StringBuilder(), a, b, c, 0, 0, 0);
    }

    public static String longestDiverseString(StringBuilder sb, int a, int b, int c, int ra, int rb, int rc){
        if((a == 0 || ra == 2) && (b == 0 || rb == 2) && (c == 0 || rc == 2)) return sb.toString();
        String maxString = "";
        if((ra < 2 && a >= b && a >= c) || (a > 0 && (rb == 2 || rc == 2))){
            sb.append('a');
            String result = longestDiverseString(sb, a- 1, b, c, ra + 1, 0, 0);
            if(result.length() > maxString.length()) maxString = result;
            sb.deleteCharAt(sb.length() - 1);
        }
        if((rb < 2 && b >= a && b >= c) || (b > 0 && (ra == 2 || rc == 2))){
            sb.append('b');
            String result = longestDiverseString(sb, a, b - 1, c, 0, rb + 1, 0);
            if(result.length() > maxString.length()) maxString = result;
            sb.deleteCharAt(sb.length() - 1);
        }
        if((rc < 2 && c >= a && c >= b) || (c > 0 && (ra == 2 || rb == 2))){
            sb.append('c');
            String result = longestDiverseString(sb, a, b, c - 1, 0, 0, rc + 1);
            if(result.length() > maxString.length()) maxString = result;
            sb.deleteCharAt(sb.length() - 1);
        }
        return maxString;
    }

    public static String longestDiverseStringPQ(int a, int b, int c){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        if(a > 0) pq.add(new Pair(a, 'a'));
        if(b > 0) pq.add(new Pair(b, 'b'));
        if(c > 0) pq.add(new Pair(c, 'c'));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == current.character && sb.charAt(sb.length() - 2) == current.character){
                if(pq.isEmpty()) break;
                Pair next = pq.poll();
                sb.append(next.character);
                if(--next.count > 0) pq.add(next);
            }
            sb.append(current.character);
            if(--current.count > 0) pq.add(current);
        }
        return sb.toString();
    }

    public static class Pair {
        public int count;
        public char character;
        public Pair(int count, char character){
            this.count = count;
            this.character = character;
        }
    }
}
