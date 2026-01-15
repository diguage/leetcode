package com.diguage.algo.leetcode;

public class _0115_DistinctSubsequences_2a {
  // tag::answer[]
  /**
   * 暴力破解（55/66）
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-15 09:22:47
   */
  public int numDistinct(String s, String t) {
    return dfs(s.toCharArray(), s.length() - 1, t.toCharArray(), t.length() - 1);
  }

  private int dfs(char[] s, int si, char[] t, int ti) {
    // 如果目标字符串的长度为 0，则只有一种方式
    if (ti < 0) {
      return 1;
    }
    // 如果来源字符串为 0，则无法组成目标字符串
    if (si < 0) {
      return 0;
    }
    int result = dfs(s, si - 1, t, ti);
    if (s[si] == t[ti]) {
      result += dfs(s, si - 1, t, ti - 1);
    }
    return result;
  }
  // end::answer[]

}
