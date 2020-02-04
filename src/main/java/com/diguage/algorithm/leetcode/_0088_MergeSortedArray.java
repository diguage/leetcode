package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * = 88. Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/[Merge Sorted Array - LeetCode]
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * *Note:*
 *
 * * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * .Example:
 * [source]
 * ----
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-25 00:43
 */
public class _0088_MergeSortedArray {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     *
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int mi = m - 1;
        int ni = n - 1;
        int i = m + n - 1;
        while (mi >= 0 && ni >= 0) {
            if (nums1[mi] > nums2[ni]) {
                nums1[i] = nums1[mi];
                i--;
                mi--;
            } else {
                nums1[i] = nums2[ni];
                i--;
                ni--;
            }
        }
        while (ni >= 0) {
            nums1[i] = nums2[ni];
            i--;
            ni--;
        }
    }

    public static void main(String[] args) {
        _0088_MergeSortedArray solution = new _0088_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
