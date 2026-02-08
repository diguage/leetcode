package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0044_WildcardMatching_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-08 23:06:06
   */
  public boolean isMatch(String s, String p) {
    int sl = s.length();
    int pl = p.length();
    boolean[][] dp = new boolean[pl + 1][sl + 1];
    dp[0][0] = true;
    if (!p.isEmpty() && p.charAt(0) == '*') {
      Arrays.fill(dp[1], true);
    }
    for (int pi = 1; pi <= pl; pi++) {
      dp[pi][0] = p.charAt(pi - 1) == '*';
      if (!dp[pi][0]) {
        break;
      }
    }
    for (int pi = 1; pi <= pl; pi++) {
      for (int si = 1; si <= sl; si++) {
        if (p.charAt(pi - 1) == s.charAt(si - 1) || p.charAt(pi - 1) == '?') {
          dp[pi][si] = dp[pi - 1][si - 1];
        } else if (p.charAt(pi - 1) == '*') {
          // 状态转移方程分为两种情况，即使用或不使用这个星号
          dp[pi][si] = dp[pi - 1][si] || dp[pi][si - 1];
        }
      }
    }
    return dp[pl][sl];
  }
  // end::answer[]
}
