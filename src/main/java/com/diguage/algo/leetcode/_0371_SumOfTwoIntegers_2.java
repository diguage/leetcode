package com.diguage.algo.leetcode;

public class _0371_SumOfTwoIntegers_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 19:56:29
   */
  public int getSum(int a, int b) {
    // 循环，当进位为 0 时跳出
    while (b != 0) {
      int c = (a & b) << 1; // c = 进位
      a ^= b;  // a = 非进位和
      b = c;  // b = 进位
    }
    return a;
  }
  // end::answer[]
}
