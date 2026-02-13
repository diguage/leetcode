package com.diguage.algo.leetcode;

public class _0372_SuperPow_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-13 22:00:02
   */
  static final int DIVISOR = 1337;

  public int superPow(int a, int[] b) {
    int result = 1;
    for (int i = b.length - 1; i >= 0; i--) {
      result = (result * (pow(a, b[i]) % DIVISOR)) % DIVISOR;
      a = pow(a, 10);
    }
    return result;
  }

  private int pow(int a, int p) {
    int result = 1;
    while (p != 0) {
      a %= DIVISOR;
      if (a == 1) {
        return a;
      }
      if (p % 2 != 0) {
        result = (result * a) % DIVISOR;
      }
      a *= a;
      p /= 2;
    }
    return result;
  }
  // end::answer[]
}
