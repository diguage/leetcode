package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0091_DecodeWays_3c {
  // tag::answer[]
  /**
   * 暴力破解（23/269）-> 备忘录（4.04%）-> 动态规划（4.04%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-25 23:25:59
   */
  public int numDecodings(String s) {
    Map<String, String> dict = new HashMap<>();
    for (int i = 1; i <= 26; i++) {
      dict.put(String.valueOf(i), String.valueOf((char) ((i - 1) + 'A')));
    }
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    // dp[i] = dp[i-1] + dp[i-2]
    for (int i = 1; i <= s.length(); i++) {
      String s1 = s.substring(i - 1, i);
      if (dict.containsKey(s1)) {
        dp[i] += dp[i - 1];
      }
      if (i >= 2) {
        String s2 = s.substring(i - 2, i);
        if (dict.containsKey(s2)) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[s.length()];
  }
  // end::answer[]
  static void main() {
    new _0091_DecodeWays_3c().numDecodings("226");
  }
}
