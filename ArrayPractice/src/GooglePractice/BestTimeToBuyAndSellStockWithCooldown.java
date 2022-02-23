package GooglePractice;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//        Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
//
//        After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

//Input: prices = [1,2,3,0,2]
//        Output: 3
//        Explanation: transactions = [buy, sell, cooldown, buy, sell]

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args){
        int[] prices={1,2,3,0,2};
        System.out.println(findMaxProfit(prices));
    }

    private static int findMaxProfit(int[] prices) {
        int noStock=0,inHand=-prices[0],sold=0;
        if(prices.length<=1){
            return 0;
        }
        for(int i=1;i<prices.length;i++){
            inHand=Math.max(inHand,noStock-prices[i]);
            noStock=Math.max(noStock,sold);
            sold=inHand+prices[i];
        }
        return Math.max(noStock,sold);
    }
}