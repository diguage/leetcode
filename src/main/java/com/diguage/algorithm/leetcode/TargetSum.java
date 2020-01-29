package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 494. Target Sum
 *
 * https://leetcode.com/problems/target-sum/[Target Sum - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-29 21:59
 */
public class TargetSum {
    /**
     * Runtime: 3 ms, faster than 90.55% of Java online submissions for Target Sum.
     * Memory Usage: 38.8 MB, less than 10.00% of Java online submissions for Target Sum.
     *
     * Copy from: https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-ji-bai-liao-98de-javayong-hu-by-r/[动态规划击败了98%的java用户 - 目标和 - 力扣（LeetCode）]
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int target = (sum + S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    /**
     * Runtime: 688 ms, faster than 5.06% of Java online submissions for Target Sum.
     * Memory Usage: 39 MB, less than 10.00% of Java online submissions for Target Sum.
     */
    private int count = 0;

    public int findTargetSumWaysDfs(int[] nums, int S) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        findTargetSumWays(nums, S, 0, 0);
        return count;
    }

    private void findTargetSumWays(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            int num = nums[index];
            findTargetSumWays(nums, target, sum + num, index + 1);
            findTargetSumWays(nums, target, sum - num, index + 1);
        }
    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] n1 = {1, 1, 1, 1, 1};
        int r1 = solution.findTargetSumWays(n1, 3);
        System.out.println((r1 == 5) + " : " + r1);
    }
}
