package com.diguage.algo.leetcode;

public class _0880_DecodedStringAtIndex {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-22 17:19:27
   */
  public String decodeAtIndex(String s, int k) {
    long[] len = new long[s.length()];
    len[0] = 1L;
    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if ('2' <= c && c <= '9') {
        len[i] = len[i - 1] * (c - '0');
      } else {
        len[i] = len[i - 1] + 1;
      }
    }
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      k = (int) (k % len[i]);
      if (k == 0 && Character.isLetter(c)) {
        return String.valueOf(c);
      }
    }
    return null;
  }
  // end::answer[]
  static void main() {
    new _0880_DecodedStringAtIndex()
//      .decodeAtIndex("ha22", 5);
//      .decodeAtIndex("leet2code3", 10);
      .decodeAtIndex("y959q969u3hb22odq595", 222280369);
  }
}
