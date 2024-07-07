package com.diguage.algo.leetcode;

/**
 * = 33. Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/[Search in Rotated Sorted Array - LeetCode]
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return `-1`.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * .Example 1:
 * [source]
 * ----
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-09-16 17:45
 */
public class _0033_SearchInRotatedSortedArray {
  // tag::answer[]
    public static int search(int[] nums, int target) {
        int result = -1;
        if (null == nums || nums.length == 0) {
            return result;
        }
        int firstNum = nums[0];
        int lastNum = nums[nums.length - 1];
        int separator = -1;
        if (firstNum > lastNum) {
            int head = 0;
            int tail = nums.length - 1;
            while (head <= tail) {
                int mid = head + (tail - head) / 2;
                int midNum = nums[mid];
                if (midNum > nums[mid + 1]) {
                    separator = mid;
                    break;
                }
                if (midNum >= firstNum) {
                    head = mid + 1;
                }
                if (midNum < lastNum) {
                    tail = mid - 1;
                }
            }
        }
        if (separator == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else {
            if (firstNum <= target && target <= nums[separator]) {
                return binarySearch(nums, target, 0, separator);
            } else {
                return binarySearch(nums, target, separator + 1, nums.length - 1);
            }
        }
    }

    private static int binarySearch(int[] nums, int target, int headIndex, int tailIndex) {
        int head = headIndex;
        int tail = tailIndex;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            if (target <= midNum) {
                tail = mid - 1;
            }
            if (midNum < target) {
                head = mid + 1;
            }
        }
        return -1;
    }

  // end::answer[]


    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        int target = 0;

//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        int target = 3;

//        int[] nums = new int[]{1};
//        int target = 1;

//        int[] nums = new int[]{1};
//        int target = 0;

//        int[] nums = new int[]{1, 3};
//        int target = 0;

//        int[] nums = new int[]{3, 1};
//        int target = 1;

        int[] nums = new int[]{4, 5, 1, 2, 3};
        int target = 1;
        System.out.println(search(nums, target));
    }
}
