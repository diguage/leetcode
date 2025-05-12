package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0350_IntersectionOfTwoArraysIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-12 16:40:45
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> numToCnt = new HashMap<>();
    for (int i : nums1) {
      Integer cnt = numToCnt.getOrDefault(i, 0);
      numToCnt.put(i, cnt + 1);
    }
    List<Integer> result = new ArrayList<>();
    for (int i : nums2) {
      Integer cnt = numToCnt.getOrDefault(i, 0);
      if (cnt > 0) {
        result.add(i);
        numToCnt.put(i, cnt - 1);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
  // end::answer[]
}
