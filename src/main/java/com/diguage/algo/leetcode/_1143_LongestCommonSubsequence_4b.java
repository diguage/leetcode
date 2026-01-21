package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1143_LongestCommonSubsequence_4b {
  // tag::answer[]
  /**
   * 暴力破解（15/47）-> 备忘录（5.83%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-21 17:37
   */
  public int longestCommonSubsequence(String a, String b) {
    int[][] memo = new int[a.length()][b.length()];
    for (int[] m : memo) {
      Arrays.fill(m, -1);
    }
    return dfs(a.toCharArray(), a.length() - 1, b.toCharArray(), b.length() - 1, memo);
  }

  private int dfs(char[] a, int ai, char[] b, int bi, int[][] memo) {
    if (ai < 0 || bi < 0) {
      return 0;
    }
    if (memo[ai][bi] >= 0) {
      return memo[ai][bi];
    }
    int result = Math.max(dfs(a, ai - 1, b, bi, memo), dfs(a, ai, b, bi - 1, memo));
    if (a[ai] == b[bi]) {
      result = Math.max(result, dfs(a, ai - 1, b, bi - 1, memo) + 1);
    }
    return memo[ai][bi] = result;
  }
  // end::answer[]

  static void main() {
    new _1143_LongestCommonSubsequence_4b().longestCommonSubsequence("abcde", "ace");
  }
}
