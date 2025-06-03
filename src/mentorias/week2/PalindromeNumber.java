package mentorias.week2;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int number){
        if(number < 0) return false;
        String numberString = String.valueOf(number);
        int left = 0;
        int right = numberString.length() - 1;
        while(left < right) if(numberString.charAt(left++) != numberString.charAt(right--)) return false;
        return true;
    }
}
