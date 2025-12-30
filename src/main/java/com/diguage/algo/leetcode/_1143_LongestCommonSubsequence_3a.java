package com.diguage.algo.leetcode;

public class _1143_LongestCommonSubsequence_3a {
  // tag::answer[]

  /**
   * 暴力破解（18/47）
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-30 20:23:25
   */
  public int longestCommonSubsequence(String text1, String text2) {
    return dfs(text1.toCharArray(), text1.length() - 1, text2.toCharArray(), text2.length() - 1);
  }

  private int dfs(char[] a, int ai, char[] b, int bi) {
    if (ai < 0 || bi < 0) {
      return 0;
    }
    if (a[ai] == b[bi]) {
      return dfs(a, ai - 1, b, bi - 1) + 1;
    } else {
      return Math.max(dfs(a, ai - 1, b, bi), dfs(a, ai, b, bi - 1));
    }
  }
  // end::answer[]
}
