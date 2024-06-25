package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 198. House Robber
 *
 * https://leetcode.com/problems/house-robber/[House Robber - LeetCode]
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and *it will automatically contact the police if two adjacent houses were broken into on the same night.*
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight *without alerting the police.*
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-23 22:37
 */
public class _0198_HouseRobber {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     *
     * Memory Usage: 41.2 MB, less than 5.26% of Java online submissions for House Robber.
     */
    public int rob(int[] nums) {
        int k2 = 0;
        int k1 = 0;
        for (int num : nums) {
            int current = Math.max(k2 + num, k1);
            k2 = k1;
            k1 = current;
        }
        return k1;
    }

    /**
     * Runtime: 1 ms, faster than 5.81% of Java online submissions for House Robber.
     *
     * Memory Usage: 41.9 MB, less than 5.26% of Java online submissions for House Robber.
     */
    public int robDP(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 2; i < memo.length; i++) {
            int max = Math.max(memo[i - 2] + nums[i - 1], memo[i - 1]);
            memo[i] = max;
        }
        return memo[nums.length];
    }

    /**
     * Runtime: 1 ms, faster than 5.81% of Java online submissions for House Robber.
     *
     * Memory Usage: 41.3 MB, less than 5.26% of Java online submissions for House Robber.
     */
    public int robRecursionWithMemo(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[0] = nums[0];
        rob(nums, memo, nums.length - 1);
        return memo[nums.length - 1];
    }

    private int rob(int[] nums, int[] memo, int k) {
        if (k == -2 || k == -1) {
            return 0;
        }

        int rob2 = 0;
        if (k - 2 >= 0 && memo[k - 2] >= 0) {
            rob2 = memo[k - 2];
        } else {
            rob2 = rob(nums, memo, k - 2);
        }
        int rob1 = 0;
        if (k - 1 >= 0 && memo[k - 1] >= 0) {
            rob1 = memo[k - 1];
        } else {
            rob1 = rob(nums, memo, k - 1);
        }
        int rob0 = Math.max(rob2 + nums[k], rob1);
        memo[k] = rob0;
        return rob0;
    }


    // -----
    public int robRecursion(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int k) {
        if (k == -2 || k == -1) {
            return 0;
        }
        return Math.max(rob(nums, k - 2) + nums[k], rob(nums, k - 1));
    }

    public static void main(String[] args) {
        _0198_HouseRobber solution = new _0198_HouseRobber();
        int[] n1 = {1, 2, 3, 1};
        int r1 = solution.rob(n1);
        System.out.println((r1 == 4) + " : " + r1);

        int[] n2 = {2, 7, 9, 3, 1};
        int r2 = solution.rob(n2);
        System.out.println((r2 == 12) + " : " + r2);
    }
}
