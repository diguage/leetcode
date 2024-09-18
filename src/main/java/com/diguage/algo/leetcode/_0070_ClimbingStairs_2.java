package com.diguage.algo.leetcode;

public class _0070_ClimbingStairs_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 22:40:33
   */
  public int climbStairs(int n) {
    if (n < 3) {
      return n;
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
