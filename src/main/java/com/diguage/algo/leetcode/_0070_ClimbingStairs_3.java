package com.diguage.algo.leetcode;

public class _0070_ClimbingStairs_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-21 23:18:37
   */
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int a = 1, b = 2;
    for (int i = 3; i <= n; i++) {
      int sum = a + b;
      a = b;
      b = sum;
    }
    return b;
  }
  // end::answer[]
}
