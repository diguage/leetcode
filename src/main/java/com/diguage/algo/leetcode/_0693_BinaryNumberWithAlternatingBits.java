package com.diguage.algo.leetcode;

public class _0693_BinaryNumberWithAlternatingBits {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-19 23:03:23
   */
  public boolean hasAlternatingBits(int n) {
    System.out.println(Integer.toBinaryString(n));
    if (n == 1) {
      return true;
    }
    int a0 = n & 1, b0 = (n >> 1) & 1;
    if (a0 == b0) {
      return false;
    }
    while (n >= 2) {
      int a = n & 1;
      n = n >> 1;
      int b = n & 1;
      if (a != a0 || b != b0) {
        return false;
      }
      n = n >> 1;
    }
    if (n > 0) {
      return n == a0;
    } else {
      return true;
    }
  }

  // end::answer[]
  static void main() {
    new _0693_BinaryNumberWithAlternatingBits().hasAlternatingBits(9);
  }
}
