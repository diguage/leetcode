package com.diguage.algo.leetcode;

public class _0461_HammingDistance {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-27 22:15:43
   */
  public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int count = 0;
    while (xor != 0) {
      // Brian Kernighan 算法，可以跳过中间的 0
      xor = xor & (xor - 1);
      count++;
      // 移位计算法
      // count += (xor & 1);
      // xor >>= 1;
    }
    return count;
  }
  // end::answer[]
}
