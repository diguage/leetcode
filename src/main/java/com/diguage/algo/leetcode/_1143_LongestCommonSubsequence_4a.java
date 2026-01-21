package com.diguage.algo.leetcode;

public class _1143_LongestCommonSubsequence_4a {
  // tag::answer[]
  /**
   * 暴力破解（15/47）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-21 17:15:34
   */
  public int longestCommonSubsequence(String a, String b) {
    return dfs(a.toCharArray(), a.length() - 1, b.toCharArray(), b.length() - 1);
  }

  private int dfs(char[] a, int ai, char[] b, int bi) {
    if (ai < 0 || bi < 0) {
      return 0;
    }
    int result = Math.max(dfs(a, ai - 1, b, bi), dfs(a, ai, b, bi - 1));
    if (a[ai] == b[bi]) {
      result = Math.max(result, dfs(a, ai - 1, b, bi - 1) + 1);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _1143_LongestCommonSubsequence_4a()
      .longestCommonSubsequence("abcde", "ace");
  }
}
