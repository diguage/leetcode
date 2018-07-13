package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * = 1. Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/[Two Sum - LeetCode]
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * .Example:
 * [source]
 * ----
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-06-30
 */
public class TwoSum {
    /**
     * 原始算法，时间复杂度为 `O(n^2^)`.
     *
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * 优化后的算法，时间复杂度减低为 `O(n)`， 空间复杂度提高了。
     *
     * @param nums   数组
     * @param target 目标
     * @return 结果
     */
    public static int[] twoSumO1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> diffNumToIndexMap = new HashMap<>(nums.length * 4 / 3);
        for (int i = 0; i < nums.length; i++) {
            if (diffNumToIndexMap.containsKey(nums[i])) {
                return new int[]{diffNumToIndexMap.get(nums[i]), i};
            } else {
                diffNumToIndexMap.put(target - nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 9, 2, 7, 11, 15};
        int target = 8;
        System.out.println(Arrays.toString(twoSumO1(nums, target)));
    }
}
