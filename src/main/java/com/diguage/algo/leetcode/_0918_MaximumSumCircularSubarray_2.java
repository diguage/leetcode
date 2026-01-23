package com.diguage.algo.leetcode;

public class _0918_MaximumSumCircularSubarray_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-23 17:58:56
   */
  public int maxSubarraySumCircular(int[] nums) {
    int maxF = 0;
    int maxS = Integer.MIN_VALUE;
    int minF = 0;
    int minS = 0;
    int sum = 0;
    for (int num : nums) {
      maxF = Math.max(maxF, 0) + num;
      maxS = Math.max(maxS, maxF);
      minF = Math.min(minF, 0) + num;
      minS = Math.min(minS, minF);
      sum += num;
    }
    return maxS < 0 ? maxS : Math.max(maxS, sum - minS);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0918_MaximumSumCircularSubarray_2()
      .maxSubarraySumCircular(new int[]{5, -3, 5});
  }
}
