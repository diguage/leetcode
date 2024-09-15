package com.diguage.algo.leetcode;

public class _0231_PowerOfTwo {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 20:19:55
   */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
  // end::answer[]
}
