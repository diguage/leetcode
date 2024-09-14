package com.diguage.algo.leetcode;

public class _0191_NumberOf1Bits_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 15:34:01
   */
  public int hammingWeight(int n) {
    // int result = 0;
    // while (0 < n) {
    //   // 这里可以简化成一行： result += n & 1
    //   //   结果是 0，相加不影响；是 1，则正好计数。
    //   if ((n & 1) == 1) {
    //     result++;
    //   }
    //   n = n >> 1;
    // }
    // return result;
    // ------------------
    // 牛逼闪闪的减法解法
    int result = 0;
    while (n != 0) {
      result++;
      n &= n - 1;
    }
    return result;
  }
  // end::answer[]
}
