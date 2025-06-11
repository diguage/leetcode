package com.diguage.algo.leetcode;

public class _0201_BitwiseAndOfNumbersRange {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-11 23:15:14
   */
  public int rangeBitwiseAnd(int left, int right) {
    while (left < right) {
      right = right & (right - 1);
    }
    return right;
  }
  // end::answer[]
}
