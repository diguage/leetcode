package com.diguage.algo.leetcode;

public class _0509_FibonacciNumber_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 17:30:28
   */
  public int fib(int n) {
    int a = 0, b = 1, sum;
    for (int i = 0; i < n; i++) {
      sum = a + b;
      a = b;
      b = sum;
    }
    return a;
  }
  // end::answer[]
}
