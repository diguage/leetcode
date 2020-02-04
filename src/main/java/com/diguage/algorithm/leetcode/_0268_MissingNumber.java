package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 268. Missing Number
 *
 * https://leetcode.com/problems/missing-number/[Missing Number - LeetCode]
 *
 * Given an array containing n distinct numbers taken from `0, 1, 2, ..., n`, find the one that is missing from the array.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [3,0,1]
 * Output: 2
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * ----
 *
 * *Note:*
 *
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-05 21:30
 */
public class _0268_MissingNumber {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
     *
     * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Missing Number.
     *
     * Copy from: https://leetcode.com/problems/missing-number/solution/[Missing Number solution - LeetCode]
     */
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        int expectSum = nums.length * (nums.length + 1) / 2;
        return expectSum - actualSum;
    }

    /**
     * Runtime: 7 ms, faster than 24.02% of Java online submissions for Missing Number.
     *
     * Memory Usage: 39.8 MB, less than 100.00% of Java online submissions for Missing Number.
     */
    public int missingNumberSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        if (nums[nums.length - 1] == nums.length - 1) {
            return nums.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        _0268_MissingNumber solution = new _0268_MissingNumber();
        int[] a1 = {3, 0, 1};
        int r1 = solution.missingNumber(a1);
        System.out.println((r1 == 2) + " : " + r1);

        int[] a2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int r2 = solution.missingNumber(a2);
        System.out.println((r2 == 8) + " : " + r2);
    }
}
