package com.diguage.algo.leetcode;

import java.util.List;

public class _0139_WordBreak_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-05 21:17:21
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (String word : wordDict) {
        if (i < word.length()) {
          continue;
        }
        dp[i] = dp[i - word.length()]
          && word.equals(s.substring(i - word.length(), i));
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[s.length()];
  }
  // end::answer[]

  static void main() {
    new _0139_WordBreak_3()
      .wordBreak("leetcode", List.of("leet", "code"));
  }
}
