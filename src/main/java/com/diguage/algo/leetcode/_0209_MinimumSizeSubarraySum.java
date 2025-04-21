package com.diguage.algo.leetcode;

public class _0209_MinimumSizeSubarraySum {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 20:51:40
   */
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0, right = 0, sum = 0, result = Integer.MAX_VALUE;
    while (right < nums.length) {
      sum += nums[right];
      right++;
      while (sum >= target) {
        result = Math.min(result, right - left);
        sum -= nums[left];
        left++;
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
  // end::answer[]
}
