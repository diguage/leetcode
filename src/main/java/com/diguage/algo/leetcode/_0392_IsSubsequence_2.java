package com.diguage.algo.leetcode;

public class _0392_IsSubsequence_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-13 20:18:27
   */
  public boolean isSubsequence(String s, String t) {
    if (s == null || s.isEmpty()) {
      return true;
    }
    if (t == null || t.isEmpty() || s.length() > t.length()) {
      return false;
    }
    int m = 0, n = 0;
    while (m < s.length() && n < t.length()) {
      if (s.charAt(m) == t.charAt(n)) {
        m++;
      }
      n++;
    }
    return m == s.length();
  }
  // end::answer[]
}
