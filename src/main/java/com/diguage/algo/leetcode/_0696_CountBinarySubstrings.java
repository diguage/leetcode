package com.diguage.algo.leetcode;

public class _0696_CountBinarySubstrings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-20 22:35:21
   */
  public int countBinarySubstrings(String s) {
    char[] chars = s.toCharArray();
    int pre = 0, cur = 0, result = 0;
    for (int i = 0; i < chars.length; i++) {
      cur++;
      if (i == s.length() - 1 || chars[i] != chars[i + 1]) {
        result += Math.min(pre, cur);
        pre = cur;
        cur = 0;
      }
    }
    return result;
  }
  // end::answer[]
}
