package com.diguage.algorithm.leetcode;

/**
 * = 154. Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/[Find Minimum in Rotated Sorted Array II - LeetCode^]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 23:32
 */
public class _0154_FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        _0154_FindMinimumInRotatedSortedArrayII solution = new _0154_FindMinimumInRotatedSortedArrayII();
        int r3 = solution.findMin(new int[]{3, 1, 1});
        System.out.println(r3);

        int r1 = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(r1);

        int r2 = solution.findMin(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 0, 1});
        System.out.println(r2);
    }
}
