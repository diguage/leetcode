package com.diguage.algo.leetcode;

public class _0396_RotateFunction {
  // tag::answer[]

  /**
   * 使用前缀和优化重复计算，再利用滑动窗口完成计算。
   * <p>
   * 优化前：通过 45 / 58 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-30 23:02:24
   */
  public int maxRotateFunction(int[] nums) {
    int n = nums.length;
    int[] sum = new int[2 * n + 1];
    for (int i = 1; i <= 2 * n; i++) {
      sum[i] = sum[i - 1] + nums[(i - 1) % n];
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      result += nums[i] * i;
    }
    for (int i = n + 1, cur = result; i < 2 * n; i++) {
      cur += nums[(i - 1) % n] * (n - 1);
      cur -= sum[i - 1] - sum[i - n];
      if (cur > result) {
        result = cur;
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    System.out.println(new _0396_RotateFunction().maxRotateFunction(new int[]{4, 3, 2, 6}));
  }
}
