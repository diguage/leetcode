package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * == 34. Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/[Find First and Last Position of Element in Sorted Array - LeetCode]
 *
 * Given an array of integers `nums` sorted in ascending order, find the
 * starting and ending position of a given `target` value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return `[-1, -1]`.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-09-16 20:50
 */
public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (null == nums || nums.length == 0) {
            return result;
        }
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                index = mid;
                break;
            }
            if (target <= midNum) {
                high = mid - 1;
            }
            if (midNum < target) {
                low = mid + 1;
            }
        }
        if (index < 0) {
            return result;
        }
        int startIndex = index;
        while (startIndex >= 0 && nums[startIndex] == target) {
            startIndex--;
        }
        result[0] = startIndex + 1;

        int endIndex = index;
        while (endIndex < nums.length && nums[endIndex] == target) {
            endIndex++;
        }
        result[1] = endIndex - 1;
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int target = 8;

        int[] nums = new int[]{1};
        int target = 1;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
