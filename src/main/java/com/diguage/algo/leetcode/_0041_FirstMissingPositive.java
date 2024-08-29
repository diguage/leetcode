package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 41. First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/[First Missing Positive - LeetCode]
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,2,0]
 * Output: 3
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [3,4,-1,1]
 * Output: 2
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: [7,8,9,11,12]
 * Output: 1
 * ----
 *
 * *Note:*
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-23 12:54:29
 */
public class _0041_FirstMissingPositive {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
     *
     * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for First Missing Positive.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2019-10-23 12:54:29
     */
    public int firstMissingPositive(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 1;
        }
        int length = nums.length;
        for (int i = 0; i < length; ) {
            int iNum = nums[i];
            if (0 < iNum && iNum <= length && nums[iNum - 1] != iNum) {
                swap(nums, i, iNum - 1);
            } else {
                i++;
            }
        }
        int i = 0;
        while (i < length && nums[i] == i + 1) {
            i++;
        }

        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0041_FirstMissingPositive solution = new _0041_FirstMissingPositive();
        int i1 = solution.firstMissingPositive(new int[]{1, 2, 0});
        System.out.println((i1 == 3) + ", " + i1);

        int i2 = solution.firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println((i2 == 2) + ", " + i2);

        int i3 = solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        System.out.println((i3 == 1) + ", " + i3);
    }
}
