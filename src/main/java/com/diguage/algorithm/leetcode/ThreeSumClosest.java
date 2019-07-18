package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 16. 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/[3Sum Closest - LeetCode]
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 * .Example:
 * [source]
 * ----
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-15 00:55
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return target;
        }
        int length = nums.length;
        if (length <= 3) {
            int result = 0;
            for (int i = 0; i < length; i++) {
                result += nums[i];
            }
            return result;
        }

        int result = 0;
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int temp = Math.abs(target - sum);
                    if (temp < difference) {
                        difference = temp;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int r1 = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println((2 == r1) + " : " + r1);
    }
}
