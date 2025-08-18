package com.diguage.algo.leetcode;

public class _0443_StringCompression {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-18 22:16:42
   */
  public int compress(char[] chars) {
    int slow = 0, curr = 0, fast = 0;
    while (fast < chars.length) {
      curr = fast;
      while (fast < chars.length && chars[curr] == chars[fast]) {
        fast++;
      }
      chars[slow++] = chars[curr];
      if (fast - curr > 1) {
        String cnt = String.valueOf(fast - curr);
        for (char c : cnt.toCharArray()) {
          chars[slow++] = c;
        }
      }
    }
    return slow;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0443_StringCompression()
      .compress(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'});
  }
}
