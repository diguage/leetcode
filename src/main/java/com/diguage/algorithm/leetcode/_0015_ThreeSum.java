package com.diguage.algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * = 15. 3Sum
 *
 * https://leetcode.com/problems/3sum/description/[3Sum - LeetCode]
 *
 * Given an array `nums` of n integers, are there elements `a`, `b`, `c` in
 * `nums` such that `a + b + c = 0`? Find all unique triplets in the array
 * which gives the sum of zero.
 *
 * == Note
 *
 * The solution set must not contain duplicate triplets.
 *
 * .Example:
 * [source]
 * ----
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-19
 */
public class _0015_ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        Map<Integer, Integer> numMap = new HashMap<>(nums.length * 4 / 3 + 1);
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        if (numMap.size() == 1 && numMap.keySet().contains(0)) {
            result.add(Arrays.asList(0, 0, 0));
            return new ArrayList<>(result);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int minuend = 0 - (nums[i] + nums[j]);
                if (numMap.containsKey(minuend)) {
                    Integer k = numMap.get(minuend);
                    if (i != k && j != k) {
                        int[] oneResult = new int[]{nums[i], nums[j], minuend};
                        Arrays.sort(oneResult);
                        result.add(Arrays.stream(oneResult).boxed().collect(Collectors.toList()));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
