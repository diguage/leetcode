package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 162. Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/[Find Peak Element - LeetCode]
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * ----
 *
 * *Note:*
 *
 * Your solution should be in logarithmic complexity.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-05 11:03
 */
public class _0162_FindPeakElement {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     *
     * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Find Peak Element.
     *
     * Copy form: https://leetcode.com/problems/find-peak-element/solution/[Find Peak Element solution - LeetCode]
     */
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (nums[mid] < nums[mid + 1]) {
            return search(nums, mid + 1, high);
        }
        return search(nums, low, mid);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     *
     * Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Find Peak Element.
     */
    public int findPeakElementLinearScan(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isPeak(nums, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isPeak(int[] nums, int index) {
        if (0 < index - 1 && nums[index - 1] > nums[index]) {
            return false;
        }
        if (index + 1 < nums.length && nums[index] < nums[index + 1]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _0162_FindPeakElement solution = new _0162_FindPeakElement();
        int[] a1 = {1, 2, 3, 1};
        int r1 = solution.findPeakElement(a1);
        System.out.println((r1 == 2) + " : " + r1);

        int[] a2 = {1, 2, 1, 3, 5, 6, 4};
        int r2 = solution.findPeakElement(a2);
        System.out.println((Arrays.asList(1, 5).contains(r2)) + " : " + r2);
    }
}
