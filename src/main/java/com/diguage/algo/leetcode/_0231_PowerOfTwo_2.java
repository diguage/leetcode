package com.diguage.algo.leetcode;

public class _0231_PowerOfTwo_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 20:19:55
   */
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    if (n == 1 || n == 2) {
      return true;
    }
    if (n % 2 == 1) {
      return false;
    }
    // 注意：这里必须用 long，否则会溢出导致 pow 成为一个更小的数字
    long pow = 2;
    while (pow < n) {
      if (pow * pow <= n) {
        pow = pow * pow;
      } else {
        pow *= 2;
      }
    }
    return pow == n;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0231_PowerOfTwo_2().isPowerOfTwo(131072);
  }
}
