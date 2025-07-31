package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0397_IntegerReplacement {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-31 22:46:36
   */
  public int integerReplacement(int n) {
    Map<Long, Integer> memo = new HashMap<>();
    return integerReplacement((long) n, memo);
  }

  private int integerReplacement(long n, Map<Long, Integer> memo) {
    if (n == 1) {
      return 0;
    } else {
      if (memo.containsKey(n)) {
        return memo.get(n);
      } else {
        int result = 0;
        if ((n & 1) == 0) {
          long next = n / 2;
          result += integerReplacement(next, memo) + 1;
        } else {
          result += Math.min(integerReplacement(n - 1, memo), integerReplacement(n + 1, memo)) + 1;
        }
        memo.put(n, result);
        return result;
      }
    }
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0397_IntegerReplacement().integerReplacement(2147483647);
  }
}
