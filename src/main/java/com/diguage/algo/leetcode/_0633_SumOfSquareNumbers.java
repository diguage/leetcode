package com.diguage.algo.leetcode;

public class _0633_SumOfSquareNumbers {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-12 20:08:19
   */
  public boolean judgeSquareSum(int c) {
    for (long a = 0; a * a <= c; a++) {
      double b = Math.sqrt(c - a * a);
      if (b == (int) b) {
        return true;
      }
    }
    return false;
  }

  // end::answer[]
  static void main() {
    new _0633_SumOfSquareNumbers().judgeSquareSum(3);
  }
}
