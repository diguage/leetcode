package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0151_ReverseWordsInAString_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-09 21:36:52
   */
  public String reverseWords(String s) {
    List<String> result = new ArrayList<>();
    int idx = 0;
    while (idx < s.length()) {
      int end = s.indexOf(" ", idx);
      if (end == -1) {
        result.add(s.substring(idx));
        break;
      } else if (idx == end) {
        idx++;
      } else {
        result.add(s.substring(idx, end));
        idx = end + 1;
      }
    }
    int left = 0, right = result.size() - 1;
    while (left < right) {
      String word = result.get(left);
      result.set(left, result.get(right));
      result.set(right, word);
      left++;
      right--;
    }
    return String.join(" ", result);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0151_ReverseWordsInAString_2()
      .reverseWords("the sky is blue");
  }
}
