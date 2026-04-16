package com.diguage.algo.leetcode;

public class _0643_MaximumAverageSubarrayI {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-16 23:42:27
   */
  public double findMaxAverage(int[] nums, int k) {
    long sum = 0L;
    long result = Long.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    result = Math.max(result, sum);
    for (int i = k; i < nums.length; i++) {
      sum += nums[i];
      sum -= nums[i - k];
      result = Math.max(result, sum);
    }
    return 1.0D * result / k;
  }
  // end::answer[]
  static void main() {
    new _0643_MaximumAverageSubarrayI()
      .findMaxAverage(new int[]{-1}, 1);
  }
}
