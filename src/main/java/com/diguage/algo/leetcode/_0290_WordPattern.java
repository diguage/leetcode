package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0290_WordPattern {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-15 22:50:10
   */
  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> map = new HashMap<>();
    int start = 0;
    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      int end = s.indexOf(" ", start);
      String word;
      if (i == pattern.length() - 1) {
        word = s.substring(start);
        if (end == -1) {
          end = pattern.length();
        } else {
          return false;
        }
      } else {
        if (end == -1) {
          return false;
        } else {
          word = s.substring(start, end);
        }
      }
      if (map.containsKey(c)) {
        if (!map.get(c).equals(word)) {
          return false;
        }
      } else {
        if (map.containsValue(word)) {
          return false;
        }
        map.put(c, word);
      }
      start = end + 1;
    }
    if (start < pattern.length()) {
      return false;
    }
    return true;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0290_WordPattern().wordPattern("a", "cat cat cat cat");
  }
}
