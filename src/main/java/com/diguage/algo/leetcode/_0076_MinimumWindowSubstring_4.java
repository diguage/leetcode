package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _0076_MinimumWindowSubstring_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-17 21:03:03
   */
  public String minWindow(String s, String t) {
    Map<Character, Integer> counter = new HashMap<>();
    for (char c : t.toCharArray()) {
      counter.put(c, counter.getOrDefault(c, 0) + 1);
    }
    int left = 0, right = 0;
    char[] chars = s.toCharArray();
    int length = Integer.MAX_VALUE;
    String result = "";
    Map<Character, Integer> window = new HashMap<>();
    int valid = 0;
    while (right < chars.length) {
      char c = chars[right++];
      window.put(c, window.getOrDefault(c, 0) + 1);
      if (counter.containsKey(c) && Objects.equals(counter.get(c), window.get(c))) {
        valid++;
      }
      while (valid == counter.size()) {
        if (right - left < length) {
          length = right - left;
          result = s.substring(left, right);
        }
        char lc = chars[left++];
        Integer cnt = window.getOrDefault(lc, 0);
        if (counter.containsKey(lc) && Objects.equals(cnt, counter.get(lc))) {
          valid--;
        }
        window.put(lc, cnt - 1);
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0076_MinimumWindowSubstring_4().minWindow("ADOBECODEBANC", "ABC");
  }
}
