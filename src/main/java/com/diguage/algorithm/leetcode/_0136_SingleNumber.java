package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 136. Single Number
 *
 * https://leetcode.com/problems/single-number/[Single Number - LeetCode]
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * *Note:*
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [2,2,1]
 * Output: 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [4,1,2,1,2]
 * Output: 4
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-01 12:38
 */
public class _0136_SingleNumber {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
     *
     * Memory Usage: 38.5 MB, less than 98.52% of Java online submissions for Single Number.
     */
    public int singleNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        _0136_SingleNumber solution = new _0136_SingleNumber();
        int[] a1 = {2, 2, 1};
        int r1 = solution.singleNumber(a1);
        System.out.println((r1 == 1) + " : " + r1);

        int[] a2 = {4, 1, 2, 1, 2};
        int r2 = solution.singleNumber(a2);
        System.out.println((r2 == 4) + " : " + r2);
    }
}
