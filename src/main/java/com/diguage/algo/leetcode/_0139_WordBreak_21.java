package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0139_WordBreak_21 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-19 17:13:31
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 0; i < s.length(); i++) {
      // 如果前 i 个字符不能被拆分，则跳过该情况
      if (!dp[i]) {
        continue;
      }
      for (String word : wordDict) {
        int wordLen = word.length();
        if (s.length() < i + wordLen) {
          continue;
        }
        // 如果已经确认可以拆分，则跳过
        if (dp[i + wordLen]) {
          continue;
        }
        String substring = s.substring(i, i + wordLen);
        // dp[i+length] = dp[i] && s[i, i+length]∈dict
        dp[i + wordLen] = dp[i] && word.equals(substring);
      }
    }
    return dp[s.length()];
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0139_WordBreak_21().wordBreak("aaaaaaa",
      new ArrayList<>(List.of("aaaa", "aaa")));
  }
}
