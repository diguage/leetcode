package com.diguage.algo.leetcode;

public class _0821_ShortestDistanceToACharacter {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-12 20:55:35
   */
  public int[] shortestToChar(String s, char c) {
    int[] result = new int[s.length()];
    char[] chars = s.toCharArray();
    // 从左向右遍历
    for (int i = 0, idx = -s.length(); i < chars.length; i++) {
      if (chars[i] == c) {
        idx = i;
      }
      result[i] = i - idx;
    }
    // 从右向左遍历
    for (int i = s.length() - 1, idx = 2 * s.length(); i >= 0; i--) {
      if (chars[i] == c) {
        idx = i;
      }
      result[i] = Math.min(result[i], idx - i);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0821_ShortestDistanceToACharacter().shortestToChar("loveleetcode", 'e');
  }
}
