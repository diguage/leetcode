package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2507_SmallestValueAfterReplacingWithSumOfPrimeFactors {
  // tag::answer[]

  /**
   * Copy  https://leetcode.cn/problems/smallest-value-after-replacing-with-sum-of-prime-factors/solutions/2024532/bao-li-by-endlesscheng-xh0b/
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-25 15:22:24
   */
  public int smallestValue(int n) {
    int result = 0;
    int cur = n;
    for (int i = 2; i * i <= cur; i++) {
      while (cur % i == 0) {
        result += i;
        cur /= i;
      }
    }
    if (cur > 1) {
      result += cur;
    }
    return result == n ? result : smallestValue(result);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _2507_SmallestValueAfterReplacingWithSumOfPrimeFactors()
      .smallestValue(15);
  }
}
