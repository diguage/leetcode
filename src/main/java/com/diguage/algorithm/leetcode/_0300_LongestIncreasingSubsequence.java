package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 300. Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/[Longest Increasing Subsequence - LeetCode]
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * .Example:
 * [source]
 * ----
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * ----
 *
 * *Note:*
 *
 * * There may be more than one LIS combination, it is only necessary for you to return the length.
 * * Your algorithm should run in O(n^2^) complexity.
 *
 * *Follow up:* Could you improve it to O(n log n) time complexity?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-23 10:24
 */
public class _0300_LongestIncreasingSubsequence {
  // tag::answer[]

    /**
     * Runtime: 2 ms, faster than 76.15% of Java online submissions for Longest Increasing Subsequence.
     *
     * Memory Usage: 42.1 MB, less than 5.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * Copy from: https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/[最长上升子序列（动态规划 + 二分查找，清晰图解） - 最长上升子序列 - 力扣（LeetCode）]
     */
    public int lengthOfLIS(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int result = 0;
        for (int num : nums) {
            int i = 0, j = result;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (result == j) {
                result++;
            }
        }
        return result;
    }

    /**
     * Runtime: 2 ms, faster than 76.15% of Java online submissions for Longest Increasing Subsequence.
     *
     * Memory Usage: 42.1 MB, less than 5.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * Copy from: https://leetcode.com/problems/longest-increasing-subsequence/solution/[Longest Increasing Subsequence solution - LeetCode]
     */
    public int lengthOfLISDPBS(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    /**
     * Runtime: 56 ms, faster than 5.76% of Java online submissions for Longest Increasing Subsequence.
     *
     * Memory Usage: 43.2 MB, less than 5.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * Copy from: https://leetcode.com/problems/longest-increasing-subsequence/solution/[Longest Increasing Subsequence solution - LeetCode]
     */
    public int lengthOfLISDP(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            result = Math.max(result, dp[i]);
        }

        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0300_LongestIncreasingSubsequence solution = new _0300_LongestIncreasingSubsequence();
        int[] n1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int r1 = solution.lengthOfLIS(n1);
        System.out.println((r1 == 4) + " : " + r1);
        int[] n2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int r2 = solution.lengthOfLIS(n2);
        System.out.println((r2 == 6) + " : " + r2);

    }
}
