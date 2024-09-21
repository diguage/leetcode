package com.diguage.algo.leetcode;

public class _0796_RotateString {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 20:48:24
   */
  public boolean rotateString(String s, String goal) {
    return (s.length() == goal.length())
      && ((s + s).contains(goal));
  }
  // end::answer[]
}
