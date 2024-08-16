package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0316_RemoveDuplicateLetters {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-28 15:16
   */
  public String removeDuplicateLetters(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    boolean[] visited = new boolean[26];
    StringBuilder chars = new StringBuilder();
    for (char c : s.toCharArray()) {
      int idx = c - 'a';
      count[idx]--;
      if (visited[idx]) {
        continue;
      }
      while (!chars.isEmpty() && chars.charAt(chars.length() - 1) > c) {
        int lastIdx = chars.charAt(chars.length() - 1) - 'a';
        if (count[lastIdx] == 0) {
          break;
        }
        chars.deleteCharAt(chars.length() - 1);
        visited[lastIdx] = false;
      }
      chars.append(c);
      visited[idx] = true;
    }
    return chars.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    _0316_RemoveDuplicateLetters solution = new _0316_RemoveDuplicateLetters();
    String result = solution.removeDuplicateLetters("bcabc");
    System.out.println(result);
  }
}
