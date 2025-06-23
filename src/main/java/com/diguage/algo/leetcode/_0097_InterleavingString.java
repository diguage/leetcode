package com.diguage.algo.leetcode;

public class _0097_InterleavingString {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-23 18:05:41
   */
  public boolean isInterleave(String s1, String s2, String s3) {
    int l = s1.length(), m = s2.length(), n = s3.length();
    if (l + m != n) {
      return false;
    }
    boolean[][] dp = new boolean[l + 1][m + 1];
    dp[0][0] = true;
    for (int r = 1; r <= l; r++) {
      dp[r][0] = s1.charAt(r - 1) == s3.charAt(r - 1);
      if (!dp[r][0]) {
        break;
      }
    }
    for (int c = 1; c <= m; c++) {
      dp[0][c] = s2.charAt(c - 1) == s3.charAt(c - 1);
      if (!dp[0][c]) {
        break;
      }
    }
    for (int r = 1; r <= l; r++) {
      for (int c = 1; c <= m; c++) {
        int i = r + c - 1;
        dp[r][c] = (dp[r - 1][c] && s1.charAt(r - 1) == s3.charAt(i))
          || (dp[r][c - 1] && s2.charAt(c - 1) == s3.charAt(i));
      }
    }
    return dp[l][m];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0097_InterleavingString().isInterleave("a", "", "a");
  }
}
