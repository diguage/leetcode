package com.diguage.algo.leetcode;

public class _1137_NThTribonacciNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-16 17:13:08
   */
  public int tribonacci(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    int a = 0, b = 1, c = 1;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = a + b + c;
      a = b;
      b = c;
      c = result;
    }
    return result;
  }
  // end::answer[]
}
