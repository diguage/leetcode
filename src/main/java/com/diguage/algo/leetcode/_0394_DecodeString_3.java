package com.diguage.algo.leetcode;

public class _0394_DecodeString_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-14 19:36:59
   */
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (index < s.length()) {
      char c = s.charAt(index);
      if ('a' <= c && c <= 'z') {
        sb.append(c);
        index++;
      } else {
        int start = index;
        int left = 0, right = -1;
        while (index < s.length() && right < left) {
          char c1 = s.charAt(index);
          if (c1 == '[') {
            left++;
          } else if (c1 == ']') {
            if (right == -1) {
              right = 1;
            } else {
              right++;
            }
          }
          index++;
        }
        String part = s.substring(start, index - 1);
        int i1 = part.indexOf("[");
        int repeat = Integer.parseInt(part.substring(0, i1));
        String is = decodeString(part.substring(i1 + 1));
        sb.append(is.repeat(repeat));
      }
    }
    return sb.toString();
  }
  // end::answer[]

  static void main() {
    new _0394_DecodeString_3()
      .decodeString("3[a2[c]]");
//      .decodeString("2[abc]3[cd]ef");
  }
}
