package com.diguage.algo.leetcode;

public class _0263_UglyNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-04 23:16:21
   */
  public boolean isUgly(int n) {
    if (n <= 0) {
      return false;
    }
    while (n > 1) {
      if (n % 2 == 0) {
        n /= 2;
      } else if (n % 3 == 0) {
        n /= 3;
      } else if (n % 5 == 0) {
        n /= 5;
      } else {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
