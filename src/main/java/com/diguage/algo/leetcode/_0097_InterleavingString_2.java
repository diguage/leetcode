package com.diguage.algo.leetcode;

public class _0097_InterleavingString_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-07 22:37:17
   */
  public boolean isInterleave(String s1, String s2, String s3) {
    int l = s1.length();
    int m = s2.length();
    int n = s3.length();
    if (l + m != n) {
      return false;
    }
    boolean[][] dp = new boolean[l + 1][m + 1];
    dp[0][0] = true;
    for (int li = 1; li <= l; li++) {
      dp[li][0] = s3.charAt(li - 1) == s1.charAt(li - 1);
      if (!dp[li][0]) {
        break;
      }
    }
    for (int mi = 1; mi <= m; mi++) {
      dp[0][mi] = s3.charAt(mi - 1) == s2.charAt(mi - 1);
      if (!dp[0][mi]) {
        break;
      }
    }
    for (int li = 1; li <= l; li++) {
      for (int mi = 1; mi <= m; mi++) {
        int i = li + mi - 1;
        dp[li][mi] = (dp[li - 1][mi] && (s3.charAt(i) == s1.charAt(li - 1)))
          || (dp[li][mi - 1] && (s3.charAt(i) == s2.charAt(mi - 1)));
      }
    }
    return dp[l][m];
  }
  // end::answer[]
}
