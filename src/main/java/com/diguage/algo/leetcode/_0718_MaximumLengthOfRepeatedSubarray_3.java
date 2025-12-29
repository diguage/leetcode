package com.diguage.algo.leetcode;

public class _0718_MaximumLengthOfRepeatedSubarray_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-29 19:28:31
   */
  public int findLength(int[] nums1, int[] nums2) {
    int result = 0;
    for (int i = 0; i < nums1.length; i++) {
      result = Math.max(result, findLength(nums1, i, nums2, 0));
    }
    for (int i = 1; i < nums2.length; i++) {
      result = Math.max(result, findLength(nums1, 0, nums2, i));
    }
    return result;
  }

  private int findLength(int[] a, int ai, int[] b, int bi) {
    int result = 0;
    int temp = 0;
    while (ai < a.length && bi < b.length) {
      if (a[ai] == b[bi]) {
        temp++;
      } else {
        temp = 0;
      }
      result = Math.max(result, temp);
      ai++;
      bi++;
    }
    return result;
  }
  // end::answer[]
}
