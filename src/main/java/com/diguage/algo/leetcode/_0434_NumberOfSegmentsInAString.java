package com.diguage.algo.leetcode;

public class _0434_NumberOfSegmentsInAString {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-29 20:49:07
   */
  public int countSegments(String s) {
    int result = 0;
    boolean flag = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        flag = false;
        continue;
      }
      if (!flag) {
        result++;
        flag = true;
      }
    }
    return result;
  }
  // end::answer[]
}
