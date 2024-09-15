package com.diguage.algo.leetcode;

public class _0050_PowXN_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 17:13:46
   */
  public double myPow(double x, long n) {
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    double tmp = myPow(x, n / 2);
    return tmp * tmp * ((n & 1) == 0 ? 1 : x);
  }
  // end::answer[]
}
