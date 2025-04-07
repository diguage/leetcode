package com.diguage.algo.leetcode;

public class _0088_MergeSortedArray_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-07 12:17:09
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int mt = m - 1, nt = nums2.length - 1;
    int idx = nums1.length - 1;
    while (0 <= mt || 0 <= nt) {
      if (0 <= mt && 0 <= nt) {
        if (nums2[nt] <= nums1[mt]) {
          nums1[idx] = nums1[mt];
          mt--;

        } else {
          nums1[idx] = nums2[nt];
          nt--;
        }
      } else if (0 <= mt) {
        nums1[idx] = nums1[mt];
        mt--;
      } else if (0 <= nt) {
        nums1[idx] = nums2[nt];
        nt--;
      }
      idx--;
    }
  }
  // end::answer[]
}
