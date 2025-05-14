package com.diguage.algo.leetcode;

public class _0918_MaximumSumCircularSubarray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-14 16:27:15
   */
  public int maxSubarraySumCircular(int[] nums) {
    int length = nums.length;
    int[] leftSumMax = new int[length];
    leftSumMax[0] = nums[0];
    int leftSum = nums[0];
    int result = nums[0];
    int preMax = nums[0];
    for (int i = 1; i < length; i++) {
      preMax = Math.max(preMax + nums[i], nums[i]);
      result = Math.max(result, preMax);
      leftSum += nums[i];
      leftSumMax[i] = Math.max(leftSumMax[i - 1], leftSum);
    }
    int rightMaxSum = 0;
    for (int i = length - 1; i > 0; i--) {
      rightMaxSum += nums[i];
      result = Math.max(result, rightMaxSum + leftSumMax[i - 1]);
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0918_MaximumSumCircularSubarray()
      .maxSubarraySumCircular(new int[]{5, -3, 5});
  }
}
