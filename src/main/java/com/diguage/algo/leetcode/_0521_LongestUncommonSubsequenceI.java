package com.diguage.algo.leetcode;

public class _0521_LongestUncommonSubsequenceI {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-23 10:48:32
   */
  public int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
  // end::answer[]
}
