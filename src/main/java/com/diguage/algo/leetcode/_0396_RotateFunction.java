package com.diguage.algo.leetcode;

public class _0396_RotateFunction {
  // tag::answer[]

  /**
   * 优化前：通过 45 / 58 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-30 23:02:24
   */
  public int maxRotateFunction(int[] nums) {
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = 0; j < nums.length; j++) {
        int idx = (i + j) % nums.length;
        sum += idx * nums[j];
      }
      System.out.printf("sum = %d\n", sum);
      result = Math.max(result, sum);
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0396_RotateFunction().maxRotateFunction(new int[]{0});
  }
}
