package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0179_LargestNumber_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 22:56:48
   */
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
    if (strs[0].equals("0")) {
      return "0";
    }
    StringBuilder result = new StringBuilder();
    for (String s : strs) {
      result.append(s);
    }
    return result.toString();
  }
  // end::answer[]
}
