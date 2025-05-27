package mentorias.week1;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[][] tests = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1},
                {1},
                {1, 5}
        };
        for(int[] test : tests){
            System.out.println(maxProfit(test));
        }
    }

    public static int maxProfit(int[] prices){
        int left = 0;
        int maxProfit = 0;
        for(int right = 1 ; right < prices.length ; right++){
            int profit = prices[right] - prices[left];
            if(profit > maxProfit) maxProfit = profit;
            if(prices[right] < prices[left]) left = right;
        }
        return maxProfit;
    }
}
