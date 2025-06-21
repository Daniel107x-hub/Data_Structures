package leetcode;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("307"));
    }

    public static int numDecodings(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return s.charAt(0) != '0' ? 1 : 0;
        int[] dp = new int[s.length()];
        dp[0] =  s.charAt(0) != '0' ? 1 : 0;
        dp[1] += isValidPair(s.charAt(0), s.charAt(1)) ? 1 : 0;
        dp[1] += s.charAt(0) != '0' && s.charAt(1) != '0' ? 1 : 0;
        for(int i = 2 ; i < s.length() ; i++){
            char prev = s.charAt(i - 1);
            char current = s.charAt(i);
            if(current != '0') dp[i] += dp[i - 1];
            if(isValidPair(prev, current)) dp[i] += dp[i - 2];
        }
        return dp[s.length() - 1];
    }

    public static boolean isValidPair(char c1, char c2){
        int n1 = c1 - '0';
        int n2 = c2 - '0';
        return n1 != 0 && n1 * 10 + n2 <= 26;
    }
}
