package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _2466_CountWaysToBuildGoodStrings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025年09月29日23:03:47
   */
  public int countGoodStrings(int low, int high, int zero, int one) {
    int[] memo = new int[high + 1];
    Arrays.fill(memo, -1);
    int result = 0;
    for (int i = low; i <= high; i++) {
      result = (result + dfs(i, zero, one, memo)) % 1_000_000_007;
    }
    return result;
  }

  private int dfs(int i, int zero, int one, int[] memo) {
    if (i < 0) {
      return 0;
    }
    if (i == 0) {
      return 1;
    }
    if (memo[i] != -1) {
      return memo[i];
    }
    memo[i] = (dfs(i - zero, zero, one, memo)
      + dfs(i - one, zero, one, memo)) % 1_000_000_007;
    return memo[i];
  }
  // end::answer[]

  static void main() {
    new _2466_CountWaysToBuildGoodStrings()
//      .countGoodStrings(3, 3, 1, 1);
      .countGoodStrings(2, 3, 1, 2);
  }
}
