package com.diguage.algo.leetcode;

public class _0258_AddDigits {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-04 22:56:45
   */
  public int addDigits(int num) {
    // 最简单的解法：树根
    // return (num - 1) % 9 + 1;
    while (num >= 10) {
      int sum = 0;
      while (num > 0) {
        sum += num % 10;
        num /= 10;
      }
      num = sum;
    }
    return num;
  }
  // end::answer[]
}
