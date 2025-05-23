package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 26. Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/[Remove Duplicates from Sorted Array - LeetCode]
 *
 * Given a sorted array `nums`, remove the duplicates
 * *https://en.wikipedia.org/wiki/In-place_algorithm[in-place]* such that each
 * element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by *modifying
 * the input array* *https://en.wikipedia.org/wiki/In-place_algorithm[in-place]*
 * with O(1) extra memory.
 *
 * .Example 1:
 * [source]
 * ----
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * ----
 *
 * == Clarification
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by *reference*, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * [source]
 * ----
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-19 18:34
 */
public class _0026_RemoveDuplicatesFromSortedArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2018-07-19 18:34
   */
  public int removeDuplicates(int[] nums) {
    if (Objects.isNull(nums) || nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  public int removeDuplicates1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int result = nums.length;
    if (nums.length == 1) {
      return result;
    }

    int previousNum = nums[0];
    int minuendIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (previousNum == nums[i]) {
        minuendIndex++;
        result--;
      } else {
        previousNum = nums[i];
      }
      if (minuendIndex > 0) {
        nums[i - minuendIndex] = nums[i];
      }
    }

    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    int[] nums = {1, 2, 2};
    new _0026_RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
    System.out.println(Arrays.toString(nums));
  }
}
