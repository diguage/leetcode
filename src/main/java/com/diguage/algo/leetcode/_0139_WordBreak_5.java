package com.diguage.algo.leetcode;

import java.util.List;

public class _0139_WordBreak_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-12 22:25:23
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      if (!dp[i - 1]) {
        continue;
      }
      for (String w : wordDict) {
        if (w.equals(s.substring(i - 1, Math.min(i - 1 + w.length(), n)))) {
          dp[i - 1 + w.length()] = true;
          // 优化：到达终点直接返回
          if (dp[n]) {
            return true;
          }
        }
      }
    }
    return dp[n];
  }
  // end::answer[]
}
