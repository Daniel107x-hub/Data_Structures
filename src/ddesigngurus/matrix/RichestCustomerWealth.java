package ddesigngurus.matrix;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;  // Initialize maxWealth to 0
        for(int[] customer: accounts){
            int wealth = 0;
            for(int amount: customer) wealth += amount;
            maxWealth = Math.max(wealth, maxWealth);
        }
        return maxWealth;
    }
}
