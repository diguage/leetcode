package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0229_MajorityElementIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-02 19:42:032
   */
  public List<Integer> majorityElement(int[] nums) {
    int e1 = 1000000001, e2 = 1000000002;
    int v1 = 0, v2 = 0;
    for (int num : nums) {
      if (num == e1) {
        v1++;
      } else if (num == e2) {
        v2++;
      } else if (v1 == 0) {
        e1 = num;
        v1++;
      } else if (v2 == 0) {
        e2 = num;
        v2++;
      } else {
        v1--;
        v2--;
      }
    }
    int c1 = 0, c2 = 0;
    for (int num : nums) {
      if (v1 > 0 && num == e1) {
        c1++;
      }
      if (v2 > 0 && num == e2) {
        c2++;
      }
    }
    List<Integer> result = new ArrayList<>();
    if (c1 > nums.length / 3) {
      result.add(e1);
    }
    if (c2 > nums.length / 3) {
      result.add(e2);
    }
    return result;
  }
  // end::answer[]

}
