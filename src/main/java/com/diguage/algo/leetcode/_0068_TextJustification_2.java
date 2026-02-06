package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0068_TextJustification_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-06 20:52:34
   */
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int left = 0, right = 0;
    int length = 0;
    while (right < words.length) {
      while (right < words.length
        && length + words[right].length() + (right - left) <= maxWidth) {
        length += words[right].length();
        right++;
      }
      if (left == right - 1) {
        // 每行单个字符的
        result.add(words[left] + " ".repeat(maxWidth - words[left].length()));
      } else {
        if (right == words.length) {
          // 不是最后一层
          StringBuilder sb = new StringBuilder();
          for (int i = left; i < right; i++) {
            sb.append(words[i]);
            if (sb.length() < maxWidth) {
              sb.append(" ");
            }
          }
          String temp = sb.toString();
          result.add(temp + " ".repeat(maxWidth - temp.length()));
        } else {
          // 如果不是最后一行
          int spaceSize = maxWidth - length;
          int cap = right - left - 1;
          int size = spaceSize / cap;
          int mod = spaceSize % cap;
          StringBuilder sb = new StringBuilder();
          for (int i = left; i < right; i++) {
            sb.append(words[i]);
            if (sb.length() < maxWidth) {
              sb.append(" ".repeat(size + (mod-- > 0 ? 1 : 0)));
            }
          }
          result.add(sb.toString());
        }
      }
      left = right;
      length = 0;
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0068_TextJustification_2()
      .fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
  }
}
