package com.diguage.algo.leetcode;

public class _0470_ImplementRand10UsingRand7 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-30 21:59:24
   */
  public int rand10() {
    while (true) {
      int a = rand7();
      int b = rand7();
      int num = (a - 1) * 7 + b; // [1, 7*7]
      if (num <= 40) {
        return num % 10 + 1;
      }

      a = num - 40; // rand9
      b = rand7();
      num = (a - 1) * 7 + b; // [1, 9*7]
      if (num <= 60) {
        return num % 10 + 1;
      }

      a = num - 60; // rand3
      b = rand7();
      num = (a - 1) * 7 + b; // [1, 3*7]
      if (num <= 30) {
        return num % 10 + 1;
      }
    }
  }

  // end::answer[]
  public int rand7() {
    return 0;
  }
}
