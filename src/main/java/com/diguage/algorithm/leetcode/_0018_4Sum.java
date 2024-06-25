package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 18. 4Sum
 *
 * https://leetcode.com/problems/4sum/description/[4Sum - LeetCode]
 *
 * Given an array `nums` of n integers and an integer `target`, are there
 * elements `a`, `b`, `c`, and `d` in `nums` such that `a + b + c + d = target`?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * == Note
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * .Example:
 * [source]
 * ----
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-15 00:58
 */
public class _0018_4Sum {
    /**
     * Runtime: 4 ms, faster than 94.46% of Java online submissions for 4Sum.
     *
     * Memory Usage: 40.7 MB, less than 52.17% of Java online submissions for 4Sum.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int numCount = 4;
        if (Objects.isNull(nums) || nums.length < numCount) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        int length = nums.length;
        if (target < numCount * nums[0] || numCount * nums[length - 1] < target) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int twoSumTarget = target - nums[i] - nums[j];
                int minTwoSum = nums[j + 1] + nums[j + 2];
                int maxTwoSum = nums[length - 1] + nums[length - 2];
                if (twoSumTarget < minTwoSum || maxTwoSum < twoSumTarget) {
                    continue;
                }
                for (int m = j + 1, n = length - 1; m < n; ) {
                    int twoSum = nums[m] + nums[n];
                    if (twoSum < twoSumTarget) {
                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;
                    } else if (twoSumTarget < twoSum) {
                        while (m < n && nums[n - 1] == nums[n]) {
                            n--;
                        }
                        n--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));

                        while (m < n && nums[m] == nums[m + 1]) {
                            m++;
                        }
                        m++;

                        while (m < n && nums[n - 1] == nums[n]) {
                            n--;
                        }
                        n--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _0018_4Sum solution = new _0018_4Sum();
        List<List<Integer>> r1 = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(Arrays.deepToString(r1.toArray()));
    }
}
