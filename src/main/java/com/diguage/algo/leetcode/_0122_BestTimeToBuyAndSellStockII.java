package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 122. Best Time to Buy and Sell Stock II
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/[Best Time to Buy and Sell Stock II - LeetCode]
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-04 10:55
 */
public class _0122_BestTimeToBuyAndSellStockII {
  // tag::answer[]

    /**
     * Runtime: 1 ms, faster than 87.57% of Java online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 42.8 MB, less than 5.71% of Java online submissions for Best Time to Buy and Sell Stock II.
     *
     * Copy from: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/[一个方法团灭 6 道股票问题 - 最佳买卖股票时机含冷冻期 - 力扣（LeetCode）]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-04 10:55
     */
    public int maxProfitDp(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }
    /**
     * Runtime: 1 ms, faster than 85.09% of Java online submissions for Best Time to Buy and Sell Stock II.
     *
     * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
     */
    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
    /**
     * Runtime: 1 ms, faster than 85.09% of Java online submissions for Best Time to Buy and Sell Stock II.
     *
     * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
     *
     * 我的思路，别人的代码。
     */
    public int maxProfitPeakValleyApproach(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int result = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i++]) {
                i++;
            }
            peak = prices[i];
            result += peak - valley;
        }

        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0122_BestTimeToBuyAndSellStockII solution = new _0122_BestTimeToBuyAndSellStockII();

        int[] a1 = {7, 1, 5, 3, 6, 4};
        int r1 = solution.maxProfit(a1);
        System.out.println((r1 == 7) + " : " + r1);

        int[] a2 = {1, 2, 3, 4, 5};
        int r2 = solution.maxProfit(a2);
        System.out.println((r2 == 4) + " : " + r2);

        int[] a3 = {7, 6, 4, 3, 1};
        int r3 = solution.maxProfit(a3);
        System.out.println((r3 == 0) + " : " + r3);
    }
}
