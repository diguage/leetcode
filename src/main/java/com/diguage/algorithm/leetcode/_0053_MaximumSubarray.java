package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 53. Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/[Maximum Subarray - LeetCode]
 *
 * Given an integer array nums, find the contiguous subarray (containing at least
 * one number) which has the largest sum and return its sum.
 *
 * .Example:
 * [source]
 * ----
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * ----
 *
 * *Follow up:*
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-23 11:47
 */
public class _0053_MaximumSubarray {
  // tag::answer[]
    public int maxSubArrayDP(int[] nums) {
        // TODO Dynamic Programming
        // TODO Divide and Conquer
        return 0;
    }
    /**
     * Runtime: 1 ms, faster than 86.91% of Java online submissions for Maximum Subarray.
     *
     * Memory Usage: 42.1 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     */
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int largestSum = nums[0];
        int largestEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            largestEndingHere = Math.max(largestEndingHere + nums[i], nums[i]);
            largestSum = Math.max(largestSum, largestEndingHere);
        }
        return largestSum;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0053_MaximumSubarray solution = new _0053_MaximumSubarray();
        int r1 = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println((r1 == 6) + " : " + r1);
    }
}
