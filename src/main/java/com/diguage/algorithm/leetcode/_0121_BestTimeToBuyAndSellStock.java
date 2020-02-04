package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 121. Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/[Best Time to Buy and Sell Stock - LeetCode]
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-01 13:01
 */
public class _0121_BestTimeToBuyAndSellStock {
    /**
     * Runtime: 1 ms, faster than 69.16% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 42.6 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * Copy from: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/[一个方法团灭 6 道股票问题 - 最佳买卖股票时机含冷冻期 - 力扣（LeetCode）]
     */
    public int maxProfitDp(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1,  - prices[i]);
        }
        return dp0;
    }
    /**
     * Runtime: 3 ms, faster than 19.73% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 42.7 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * Copy from: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/[一个方法团灭 6 道股票问题 - 最佳买卖股票时机含冷冻期 - 力扣（LeetCode）]
     */
    public int maxProfitDpTable(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * Runtime: 198 ms, faster than 8.08% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * Memory Usage: 38.5 MB, less than 76.99% of Java online submissions for Best Time to Buy and Sell Stock.
     */
    public int maxProfitBruteForce(int[] prices) {
        if (Objects.isNull(prices) || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        _0121_BestTimeToBuyAndSellStock solution = new _0121_BestTimeToBuyAndSellStock();
        int[] a3 = {2, 7, 1, 4};
        int r3 = solution.maxProfit(a3);
        System.out.println((r3 == 5) + " : " + r3);

        int[] a1 = {7, 1, 5, 3, 6, 4};
        int r1 = solution.maxProfit(a1);
        System.out.println((r1 == 5) + " : " + r1);


        int[] a2 = {7, 6, 4, 3, 1};
        int r2 = solution.maxProfit(a2);
        System.out.println((r2 == 0) + " : " + r2);
    }
}
