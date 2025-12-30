package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1143_LongestCommonSubsequence_3b {
  // tag::answer[]
  /**
   * 暴力破解（18/47）→ 备忘录（5.67%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-30 20:23:25
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] memo = new int[text1.length()][text2.length()];
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
    }
    return dfs(text1.toCharArray(), text1.length() - 1, text2.toCharArray(), text2.length() - 1, memo);
  }

  private int dfs(char[] a, int ai, char[] b, int bi, int[][] memo) {
    if (ai < 0 || bi < 0) {
      return 0;
    }
    if (memo[ai][bi] >= 0) {
      return memo[ai][bi];
    }
    int result = 0;
    if (a[ai] == b[bi]) {
      result = dfs(a, ai - 1, b, bi - 1, memo) + 1;
    } else {
      result = Math.max(dfs(a, ai - 1, b, bi, memo), dfs(a, ai, b, bi - 1, memo));
    }
    memo[ai][bi] = result;
    return result;
  }
  // end::answer[]
}
