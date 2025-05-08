package com.diguage.algo.leetcode;

public class _3099_HarshadNumber {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-08 16:47:40
   */
  public int sumOfTheDigitsOfHarshadNumber(int x) {
    int sum = 0;
    int num = x;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return x % sum == 0 ? sum : -1;
  }
  // end::answer[]
}
