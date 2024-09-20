package com.diguage.algo.leetcode;

public class _0392_IsSubsequence {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 21:50:25
   */
  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int idx = 0;
    for (int i = 0; i < t.length(); i++) {
      if (idx >= s.length()){
        break;
      }
      if (t.charAt(i) == s.charAt(idx)) {
        idx++;
      }
    }
    return idx >= s.length();
  }
  // end::answer[]
}
