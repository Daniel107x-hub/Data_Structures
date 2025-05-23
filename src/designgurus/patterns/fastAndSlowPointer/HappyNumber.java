package designgurus.patterns.fastAndSlowPointer;


/*
    In this problem, we follow the same approach as the fast / slow pointers but
    we don't create the list explicitly. We get to the next "node" by calculating the sum of the digits
    and we advance 2 items by calculating repeated sums.
    The number will have a cycle, but if the cycle loops in 1 then we found a happy number.
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(find(23));
    }

    private static boolean find(int num){
        if(num == 1) return true;
        int slow = num;
        int fast = sumDigits(num);
        while(slow != fast){
            slow = sumDigits(slow);
            fast = sumDigits(sumDigits(fast));
        }
        return slow == 1;
    }

    private static int sumDigits(int num){
        int sum = 0;
        while(num > 0){
            int reminder = num % 10;
            num = num / 10;
            sum += reminder * reminder;
        }
        return sum;
    }
}
