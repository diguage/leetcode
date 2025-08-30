package com.diguage.algo.leetcode;

public class _0470_ImplementRand10UsingRand7 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-30 21:59:24
   */
  public int rand10() {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
      sum += rand7();
    }
    return sum % 10 + 1;
  }
  // end::answer[]
  public int rand7() {
    return 0;
  }
}
