package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0044_WildcardMatching {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-24 19:57:05
   */
  public boolean isMatch(String s, String p) {
    int sl = s.length(), pl = p.length();
    boolean[][] dp = new boolean[pl + 1][sl + 1];
    dp[0][0] = true;
    if (pl > 0 && p.charAt(0) == '*') {
      Arrays.fill(dp[1], true);
    }
    for (int pi = 1; pi <= pl; pi++) {
      if (p.charAt(pi - 1) == '*') {
        dp[pi][0] = true;
      } else {
        break;
      }
    }
    for (int pi = 1; pi <= pl; pi++) {
      boolean patch = false;
      for (int si = 1; si <= sl; si++) {
        if (p.charAt(pi - 1) == '*') {
          if (dp[pi - 1][0]) {
            dp[pi][0] = true;
          }
          if (dp[pi - 1][si]) {
            patch = true;
          }
          if (patch) {
            dp[pi][si] = true;
          }
        }
        if (p.charAt(pi - 1) == '?' || p.charAt(pi - 1) == s.charAt(si - 1)) {
          dp[pi][si] = dp[pi - 1][si - 1];
        }
      }
    }
    return dp[pl][sl];
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0044_WildcardMatching().isMatch("abcabczzzde", "*abc???de*");
  }
}
