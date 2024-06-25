package com.diguage.algorithm.leetcode;

/**
 * = 4. Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/[Median of Two Sorted Arrays - LeetCode]
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be latexmath:[O(log(m+n))].
 *
 * .Example 1:
 * [source]
 * ----
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-01
 */
public class _0004_MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (isEmpty(nums1) && isEmpty(nums2)) {
            return 0;
        }
        if (isEmpty(nums1)) {
            return singleArray(nums2);
        }
        if (isEmpty(nums2)) {
            return singleArray(nums1);
        }

        int length = nums1.length + nums2.length;
        boolean isOdd = (length & 1) == 1;
        int i1 = 0;
        int i2 = 0;
        int min = nums1[0] < nums2[0] ? nums1[0] : nums2[0];
        int temp = min;
        int last = min;
        int now = min;
        for (int i = 0; i < length; i++) {
            if (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] <= nums2[i2]) {
                    temp = nums1[i1];
                    i1++;
                } else {
                    temp = nums2[i2];
                    i2++;
                }
            } else if (i1 < nums1.length) {
                temp = nums1[i1];
                i1++;
            } else {
                temp = nums2[i2];
                i2++;
            }

            if (i > 0) {
                last = now;
                now = temp;
            }

            if (length / 2 == i) {
                if (isOdd) {
                    return now;
                } else {
                    return ((double) (last + now)) / 2.0;
                }
            }
        }
        return 0;
    }

    private static boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    public static double findMedianSortedArraysBest(int[] nums1, int[] nums2) {
        // TODO
        return 0;
    }

    private static double singleArray(int[] nums2) {
        boolean isOdd = (nums2.length & 1) == 1;
        if (isOdd) {
            return nums2[nums2.length / 2];
        } else {
            return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{100001};
        int[] nums2 = new int[]{100000};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
