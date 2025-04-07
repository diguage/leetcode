package com.diguage.algo.leetcode;

public class _0050_PowXN_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-07 14:26:30
   */
  public double myPow(double x, long n) {
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    boolean negative = n < 0;
    n = Math.abs(n);
    double result = 1;
    double bin = myPow(x, n / 2);
    if (n % 2 == 1) {
      result = x * bin * bin;
    } else {
      result = bin * bin;
    }
    return negative ? 1 / result : result;
  }
  // end::answer[]
}
