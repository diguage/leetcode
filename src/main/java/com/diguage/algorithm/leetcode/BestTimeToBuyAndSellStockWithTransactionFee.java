package com.diguage.algorithm.leetcode;

/**
 * = 714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/[Best Time to Buy and Sell Stock with Transaction Fee - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-28 19:48
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    /**
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock with Transaction Fee.
     * Memory Usage: 54.3 MB, less than 27.27% of Java online submissions for Best Time to Buy and Sell Stock with Transaction Fee.
     */
    public int maxProfit(int[] prices, int fee) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i] - fee);
        }
        return dp0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee solution = new BestTimeToBuyAndSellStockWithTransactionFee();
        int[] p1 = {1, 3, 2, 8, 4, 9};
        int r1 = solution.maxProfit(p1, 2);
        System.out.println((r1 == 8) + " : " + r1);
    }
}
