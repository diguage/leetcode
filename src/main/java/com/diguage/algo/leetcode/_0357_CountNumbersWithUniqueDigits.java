package com.diguage.algo.leetcode;

public class _0357_CountNumbersWithUniqueDigits {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-18 22:28:36
   */
  public int countNumbersWithUniqueDigits(int n) {
    int result = 1;
    for (int i = n; i > 0; i--) {
      if (i == 1) {
        result += 9;
      } else {
        int temp = 9 * 9;
        for (int j = 3; j <= i; j++) {
          temp *= (10 - j + 1);
        }
        result += temp;
      }
    }
    return result;
  }
  // end::answer[]
}
