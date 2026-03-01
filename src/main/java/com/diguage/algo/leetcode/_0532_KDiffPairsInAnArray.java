package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0532_KDiffPairsInAnArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-01 17:50:33
   */
  public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        if (nums[j] - nums[i] == k) {
          result++;
        }
      }
    }
    return result;
  }
  // end::answer[]
}
