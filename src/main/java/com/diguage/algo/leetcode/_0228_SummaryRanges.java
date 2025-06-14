package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0228_SummaryRanges {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-14 21:50:13
   */
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    int start = -1;
    for (int i = 0; i < nums.length; i++) {
      if (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
        if (start == -1) {
          start = i;
        }
      } else {
        if (start == -1) {
          result.add(String.valueOf(nums[i]));
        } else {
          result.add(nums[start] + "->" + nums[i]);
          start = -1;
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0228_SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
  }
}
