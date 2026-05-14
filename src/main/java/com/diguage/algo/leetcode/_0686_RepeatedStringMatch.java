package com.diguage.algo.leetcode;

public class _0686_RepeatedStringMatch {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-14 22:21:03
   */
  public int repeatedStringMatch(String a, String b) {
    if (a.contains(b)) {
      return 1;
    }
    int count = b.length() % a.length() == 0 ? b.length() / a.length()
      : b.length() / a.length() + 1;
    String repeat = a.repeat(count);
    if (repeat.contains(b)) {
      return count;
    } else if ((repeat + a).contains(b)) {
      return count + 1;
    }
    return -1;
  }
  // end::answer[]
}
