package com.diguage.algo.leetcode;

public class _0028_FindTheIndexOfTheFirstOccurrenceInAString {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-11 21:02:03
   */
  public int strStr(String haystack, String needle) {
    int m = haystack.length(), n = needle.length();
    char[] hc = haystack.toCharArray();
    char[] nc = needle.toCharArray();
    for (int i = 0; i + n < m; i++) {
      int x = i, y = 0;
      while (y < n && hc[x] == nc[y]) {
        x++;
        y++;
      }
      if (y == n) {
        return i;
      }
    }
    return -1;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0028_FindTheIndexOfTheFirstOccurrenceInAString()
      .strStr("a", "a");
  }
}
