package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 123. Best Time to Buy and Sell Stock III
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/[Best Time to Buy and Sell Stock III - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 20:14
 */
public class _0123_BestTimeToBuyAndSellStockIII {
  // tag::answer[]
    /**
     * Runtime: 2 ms, faster than 47.09% of Java online submissions for Best Time to Buy and Sell Stock III.
     * Memory Usage: 42.5 MB, less than 7.32% of Java online submissions for Best Time to Buy and Sell Stock III.
     *
     * Copy from: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/8610/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/[309. 买卖股票的最佳时机含冷冻期 - 一个方法团灭 6 道股票问题^]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-28 20:14
     */
    public int maxProfit(int[] prices) {
        int dp10 = 0, dp11 = Integer.MIN_VALUE;
        int dp20 = 0, dp21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp20 = Math.max(dp20, dp21 + prices[i]);
            dp21 = Math.max(dp21, dp10 - prices[i]);
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, -prices[i]);
        }
        return dp20;
    }

    /**
     * Runtime: 5 ms, faster than 22.10% of Java online submissions for Best Time to Buy and Sell Stock III.
     * Memory Usage: 42.4 MB, less than 7.32% of Java online submissions for Best Time to Buy and Sell Stock III.
     */
    public int maxProfitDpTable(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }
        int maxK = 2;
        int[][][] dp = new int[prices.length][maxK + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][maxK][0];
    }

  // end::answer[]


    public static void main(String[] args) {
        _0123_BestTimeToBuyAndSellStockIII solution = new _0123_BestTimeToBuyAndSellStockIII();
        int[] p1 = {3, 3, 5, 0, 0, 3, 1, 4};
        int r1 = solution.maxProfit(p1);
        System.out.println((r1 == 6) + " : " + r1);

        int[] p2 = {1, 2, 3, 4, 5};
        int r2 = solution.maxProfit(p2);
        System.out.println((r2 == 4) + " : " + r2);
    }
}
