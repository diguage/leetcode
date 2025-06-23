package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0068_TextJustification {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-23 16:26:29
   */
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int right = 0, length = words.length;
    while (true) {
      int left = right;
      int lengthSum = 0;
      while (right < length && lengthSum + words[right].length() + (right - left) <= maxWidth) {
        lengthSum += words[right++].length();
      }
      // 最后一行
      if (right == length) {
        StringBuilder sb = new StringBuilder();
        while (left < length) {
          sb.append(words[left]);
          if (left < length - 1) {
            sb.append(' ');
          }
          left++;
        }
        while (sb.length() < maxWidth) {
          sb.append(' ');
        }
        result.add(sb.toString());
        return result;
      }
      int wordCount = right - left;
      int spaceCount = maxWidth - lengthSum;
      if (wordCount == 1) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[left]);
        while (sb.length() < maxWidth) {
          sb.append(' ');
        }
        result.add(sb.toString());
        continue;
      }
      int avgSpace = spaceCount / (wordCount - 1);
      int mod = spaceCount % (wordCount - 1);
      StringBuilder sb = new StringBuilder();
      while (left < right) {
        sb.append(words[left]);
        if (left < right - 1) {
          int spaces = avgSpace + (mod-- > 0 ? 1 : 0);
          while (spaces-- > 0) {
            sb.append(' ');
          }
        }
        left++;
      }
      result.add(sb.toString());
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0068_TextJustification().fullJustify(
      new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}, 16);
  }
}
