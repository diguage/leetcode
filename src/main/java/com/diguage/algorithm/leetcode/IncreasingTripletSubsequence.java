package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 334. Increasing Triplet Subsequence
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * ****
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * ****
 *
 * *Note:* Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,2,3,4,5]
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [5,4,3,2,1]
 * Output: false
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-27 14:26
 */
public class IncreasingTripletSubsequence {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Triplet Subsequence.
     *
     * Memory Usage: 39.3 MB, less than 93.02% of Java online submissions for Increasing Triplet Subsequence.
     */
    public boolean increasingTriplet(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else if (mid < num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Runtime: 152 ms, faster than 5.23% of Java online submissions for Increasing Triplet Subsequence.
     *
     * Memory Usage: 40.4 MB, less than 6.98% of Java online submissions for Increasing Triplet Subsequence.
     */
    public boolean increasingTripletDp(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
            if (max >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();

        int[] n5 = {1, 1, -2, 6};
        boolean r5 = solution.increasingTriplet(n5);
        System.out.println(!r5);


        int[] n4 = {2, 4, -2, -3};
        boolean r4 = solution.increasingTriplet(n4);
        System.out.println(!r4);

        int[] n3 = {1, 2, 3, 1, 2, 1};
        boolean r3 = solution.increasingTriplet(n3);
        System.out.println(r3);

        int[] n1 = {1, 2, 3, 4, 5};
        boolean r1 = solution.increasingTriplet(n1);
        System.out.println(r1);

        int[] n2 = {5, 4, 3, 2, 1};
        boolean r2 = solution.increasingTriplet(n2);
        System.out.println(!r2);
    }
}
