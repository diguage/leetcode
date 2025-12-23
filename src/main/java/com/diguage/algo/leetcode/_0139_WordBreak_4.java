package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.List;

public class _0139_WordBreak_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-23 11:42:22
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0; i <= s.length(); i++) {
      if (!dp[i]) {
        continue;
      }
      for (String word : wordDict) {
        if (i + word.length() <= s.length()
          && !dp[i + word.length()]
          && word.equals(s.substring(i, i + word.length()))) {
          dp[i + word.length()] = true;
        }
        if (dp[s.length()]) {
          return true;
        }
      }
    }
    return dp[s.length()];
  }

  // end::answer[]
  public static void main(String[] args) {
    _0139_WordBreak_4 solution = new _0139_WordBreak_4();

    boolean r4 = solution.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
    System.out.println(r4);

    boolean r1 = solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
    System.out.println(r1);

    boolean r2 = solution.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
    System.out.println(r2);

    boolean r3 = solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
    System.out.println(!r3);
  }
}
