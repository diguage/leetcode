package com.diguage.algo.leetcode;

public class _0342_PowerOfFour {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-14 15:32:51
   */
  public boolean isPowerOfFour(int n) {
    return (n > 0)
      && ((n & (n - 1)) == 0)
      && ((Integer.toBinaryString(n).length() - 1) % 2 == 0);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0342_PowerOfFour().isPowerOfFour(2);
  }
}
