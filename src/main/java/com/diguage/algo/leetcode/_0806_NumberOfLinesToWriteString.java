package com.diguage.algo.leetcode;

public class _0806_NumberOfLinesToWriteString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-01 21:32:12
   */
  public int[] numberOfLines(int[] widths, String s) {
    int lines = 1, width = 0;
    for (char c : s.toCharArray()) {
      int w = widths[c - 'a'];
      if (width + w > 100) {
        lines++;
        width = w;
      } else {
        width += w;
      }
    }
    return new int[]{lines, width};
  }
  // end::answer[]
}
