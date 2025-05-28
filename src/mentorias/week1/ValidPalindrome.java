package mentorias.week1;

public class ValidPalindrome {
    public static void main(String[] args) {
        String[] tests = {
                "aba",
                "abca",
                "abc"
        };
        for(String test : tests){
            System.out.println(validPalindrome(test));
        }
    }

    public static boolean validPalindrome(String s){
        if(s.length() <= 2) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        return true;
    }

    private static boolean isPalindrome(String s, int start, int end){
        if(end - start == 0) return true;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else return false;
        }
        return true;
    }
}
