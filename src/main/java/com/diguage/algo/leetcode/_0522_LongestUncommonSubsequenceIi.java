package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0522_LongestUncommonSubsequenceIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-24 21:38:10
   */
  public int findLUSlength(String[] strs) {
    Arrays.sort(strs, (a, b) -> Integer.compare(b.length(), a.length()));
    int result = 0;
    next:
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs.length; j++) {
        if (i != j && isSubsequence(strs[i], strs[j])) {
          continue next;
        }
      }
      return strs[i].length();
    }
    return -1;
  }

  private boolean isSubsequence(String s, String t) {
    int i = 0;
    for (char c : t.toCharArray()) {
      if (s.charAt(i) == c && ++i == s.length()) {
        return true;  // s 是 t 的子序列
      }
    }
    return false;
  }
  // end::answer[]
}
