package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0115_DistinctSubsequences_2b {
  // tag::answer[]

  /**
   * 暴力破解（55/66） -> 备忘录（6.33%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-15 10:10:17
   */
  public int numDistinct(String s, String t) {
    int[][] memo = new int[s.length()][t.length()];
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
    }
    return dfs(s.toCharArray(), s.length() - 1, t.toCharArray(), t.length() - 1, memo);
  }

  private int dfs(char[] s, int si, char[] t, int ti, int[][] memo) {
    // 如果目标字符串的长度为 0，则只有一种方式
    if (ti < 0) {
      return 1;
    }
    // 如果来源字符串为 0，则无法组成目标字符串
    if (si < 0) {
      return 0;
    }
    if (memo[si][ti] >= 0) {
      return memo[si][ti];
    }
    int result = dfs(s, si - 1, t, ti, memo);
    if (s[si] == t[ti]) {
      result += dfs(s, si - 1, t, ti - 1, memo);
    }
    return memo[si][ti] = result;
  }
  // end::answer[]

}
