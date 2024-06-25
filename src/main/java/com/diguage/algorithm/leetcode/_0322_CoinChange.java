package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 322. Coin Change
 *
 * https://leetcode.com/problems/coin-change/[Coin Change - LeetCode]
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: coins = [2], amount = 3
 * Output: -1
 * ----
 *
 * *Note:*
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 22:16
 */
public class _0322_CoinChange {

    /**
     * Runtime: 91 ms, faster than 6.13% of Java online submissions for Coin Change.
     *
     * Memory Usage: 42.7 MB, less than 5.33% of Java online submissions for Coin Change.
     *
     * Copy from: https://leetcode.com/problems/coin-change/solution/[Coin Change solution - LeetCode]
     */
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int current, int[] count) {
        if (current < 0) {
            return -1;
        }
        if (current == 0) {
            return 0;
        }
        if (count[current - 1] != 0) {
            return count[current - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, current - coin, count);
            if (0 <= res && res < min) {
                min = res + 1;
            }
        }
        count[current - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[current - 1];
    }

    /**
     * Runtime: 427 ms, faster than 5.00% of Java online submissions for Coin Change.
     *
     * Memory Usage: 115.5 MB, less than 5.33% of Java online submissions for Coin Change.
     */
    public int coinChangeDpWithMemo(int[] coins, int amount) {
        int count = dpWithMemo(coins, new HashMap<>(), amount, amount);
        if (count > amount) {
            return -1;
        }
        return count;
    }

    public int dpWithMemo(int[] coins, Map<Integer, Integer> memo, int amount, int current) {
        if (current == 0) {
            return 0;
        }
        if (current < 0) {
            return amount;
        }

        List<Integer> counts = new ArrayList<>();
        for (int coin : coins) {
            int newCoin = current - coin;
            int count;
            if (memo.containsKey(newCoin)) {
                count = memo.get(newCoin);
            } else {
                count = dpWithMemo(coins, memo, amount, newCoin) + 1;
                memo.put(newCoin, count);
            }
            counts.add(count);
        }
        return Collections.min(counts);
    }

    /**
     * Time Limit Exceeded
     */
    public int coinChangeDp(int[] coins, int amount) {
        int count = dp(coins, amount, amount);
        if (count > amount) {
            return -1;
        }
        return count;
    }

    private int dp(int[] coins, int amount, int current) {
        if (current == 0) {
            return 0;
        }
        if (current < 0) {
            return amount;
        }

        List<Integer> counts = new ArrayList<>();
        for (int coin : coins) {
            counts.add(dp(coins, amount, current - coin) + 1);
        }
        return Collections.min(counts);
    }

    public static void main(String[] args) {
        _0322_CoinChange solution = new _0322_CoinChange();
        int[] c1 = {1, 2, 5};
        int r1 = solution.coinChange(c1, 11);
        System.out.println((r1 == 3) + " : " + r1);

        int[] c2 = {2};
        int r2 = solution.coinChange(c2, 3);
        System.out.println((r2 == -1) + " : " + r2);
    }
}
