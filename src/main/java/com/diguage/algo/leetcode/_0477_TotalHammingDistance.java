package com.diguage.algo.leetcode;

public class _0477_TotalHammingDistance {
  // tag::answer[]

  /**
   * 优化前：通过 35 / 46 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-03 22:03:55
   */
  public int totalHammingDistance(int[] nums) {
    int result = 0;
    for (int i = 0; i < 30; i++) {
      int cnt = 0;
      for (int num : nums) {
        cnt += (num >> i) & 1;
      }
      result += cnt * (nums.length - cnt);
    }
    return result;
  }

  // end::answer[]

  public static void main(String[] args) {
    new _0477_TotalHammingDistance()
      .totalHammingDistance(new int[]{4, 14, 2});
  }
}
