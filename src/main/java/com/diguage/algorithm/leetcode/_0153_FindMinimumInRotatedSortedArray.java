package com.diguage.algorithm.leetcode;

/**
 * = 153. Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/[Find Minimum in Rotated Sorted Array - LeetCode^]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 22:37
 */
public class _0153_FindMinimumInRotatedSortedArray {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
     * Memory Usage: 39.8 MB, less than 12.50% of Java online submissions for Find Minimum in Rotated Sorted Array.
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _0153_FindMinimumInRotatedSortedArray solution = new _0153_FindMinimumInRotatedSortedArray();
        int r1 = solution.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(r1);
        int r2 = solution.findMin(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2});
        System.out.println(r2);
    }
}
