package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 188. Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/[Best Time to Buy and Sell Stock IV - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 20:54
 */
public class _0188_BestTimeToBuyAndSellStockIV {
  // tag::answer[]
    /**
     * Runtime: 11 ms, faster than 19.87% of Java online submissions for Best Time to Buy and Sell Stock IV.
     * Memory Usage: 40.9 MB, less than 13.89% of Java online submissions for Best Time to Buy and Sell Stock IV.
     *
     * Copy from https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/[一个方法团灭 6 道股票问题 - 最佳买卖股票时机含冷冻期 - 力扣（LeetCode）]
     */
public int maxProfit(int maxK, int[] prices) {
    if (Objects.isNull(prices) || prices.length == 0 || maxK == 0) {
        return 0;
    }
    if (maxK > prices.length / 2) {
        return maxProfit(prices);
    }
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

public int maxProfit(int[] prices) {
    int dp0 = 0;
    int dp1 = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
        int temp = dp0;
        dp0 = Math.max(dp0, dp1 + prices[i]);
        dp1 = Math.max(dp1, temp - prices[i]);
    }
    return dp0;
}

  // end::answer[]


    public static void main(String[] args) {
        _0188_BestTimeToBuyAndSellStockIV solution = new _0188_BestTimeToBuyAndSellStockIV();
        int[] p1 = {2, 4, 1};
        int r1 = solution.maxProfit(2, p1);
        System.out.println((r1 == 2) + " : " + r1);

        int[] p2 = {3, 2, 6, 5, 0, 3};
        int r2 = solution.maxProfit(2, p2);
        System.out.println((r2 == 7) + " : " + r2);
    }
}
