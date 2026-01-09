package com.diguage.algo.leetcode;

public class _1047_RemoveAllAdjacentDuplicatesInString_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-09 19:43:22
   */
  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder(s.length());
    for (char c : s.toCharArray()) {
      if (!sb.isEmpty() && c == sb.charAt(sb.length() - 1)) {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
  // end::answer[]
}
