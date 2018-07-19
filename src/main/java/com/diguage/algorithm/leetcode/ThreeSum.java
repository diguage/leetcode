package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * @since 2018-07-14 15:30
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);



        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
