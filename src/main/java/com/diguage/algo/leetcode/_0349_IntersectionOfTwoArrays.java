package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0349_IntersectionOfTwoArrays {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-16 22:40:46
   */
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> list = new ArrayList<>();
    int i1 = 0, i2 = 0;
    while (i1 < nums1.length && i2 < nums2.length) {
      if (nums1[i1] == nums2[i2]) {
        if (list.isEmpty() || list.getLast() != nums1[i1]) {
          list.add(nums1[i1]);
        }
        i1++;
        i2++;
      } else if (nums1[i1] > nums2[i2]) {
        i2++;
      } else {
        i1++;
      }
    }
    return list.stream().mapToInt(x -> x).toArray();
  }
  // end::answer[]
}
