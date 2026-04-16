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
    // 使用单个循环，效率似乎略低
    for (int i = 0; i < nums.length; i++) {
      // 1. 进入窗口
      sum += nums[i];
      if (i < k - 1) {
        continue;
      }
      // 2. 更新答案
      result = Math.max(result, sum);
      // 3. 离开窗口
      sum -= nums[i - k + 1];
    }
    return 1.0D * result / k;
  }

  // end::answer[]
  static void main() {
    new _0643_MaximumAverageSubarrayI()
      .findMaxAverage(new int[]{-1}, 1);
  }
}
