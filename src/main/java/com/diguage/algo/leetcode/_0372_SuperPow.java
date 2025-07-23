package com.diguage.algo.leetcode;

public class _0372_SuperPow {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-23 12:21:04
   */
  static final int MOD = 1337;

  public int superPow(int a, int[] b) {
    int result = 1;
    for (int i = b.length - 1; i >= 0; i--) {
      result = ((result % MOD) * pow(a, b[i])) % MOD;
      a = pow(a, 10);
    }
    return result;
  }

  private int pow(int a, int x) {
    int result = 1;
    while (x != 0) {
      a %= MOD;
      if (a == 1) {
        return 1;
      }
      if (x % 2 != 0) {
        result = (result * a) % MOD;
      }
      a = (a * a) % MOD;
      x /= 2;
    }
    return result % MOD;
  }

  // end::answer[]
  public static void main(String[] args) {
    System.out.println(new _0372_SuperPow().superPow(1336, new int[]{9, 9, 9}));
  }
}
