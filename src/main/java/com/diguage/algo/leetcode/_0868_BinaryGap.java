package com.diguage.algo.leetcode;

public class _0868_BinaryGap {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-17 22:24:28
   */
  public int binaryGap(int n) {
    int result = 0;
    int temp = 0;
    while (n > 0) {
      if ((n & 1) == 1) {
        result = Math.max(result, temp);
        temp = 1;
      } else {
        if (temp > 0) {
          temp++;
        }
      }
      n >>= 1;
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0868_BinaryGap().binaryGap(8);
  }
}
