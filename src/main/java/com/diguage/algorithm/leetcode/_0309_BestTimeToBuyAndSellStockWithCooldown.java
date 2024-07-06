package com.diguage.algorithm.leetcode;

/**
 * = 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/[Best Time to Buy and Sell Stock with Cooldown - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 15:16
 */
public class _0309_BestTimeToBuyAndSellStockWithCooldown {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
     * Memory Usage: 37.9 MB, less than 25.93% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
     *
     * Copy from: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/[一个方法团灭 6 道股票问题 - 最佳买卖股票时机含冷冻期 - 力扣（LeetCode）]
     */
    public int maxProfit(int[] prices) {
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        int last = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, last - prices[i]); // buy 需要基于前一天基础上。
            last = temp;
        }
        return dp0;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0309_BestTimeToBuyAndSellStockWithCooldown solution = new _0309_BestTimeToBuyAndSellStockWithCooldown();
        int[] p1 = {1, 2, 3, 0, 2};
        int r1 = solution.maxProfit(p1);
        System.out.println((r1 == 3) + " : " + r1);
    }
}
