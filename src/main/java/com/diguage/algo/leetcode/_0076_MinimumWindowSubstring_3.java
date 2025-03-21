package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _0076_MinimumWindowSubstring_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-21 11:08:35
   */
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
      return "";
    }
    Map<Character, Integer> target = new HashMap<>();
    for (char c : t.toCharArray()) {
      target.put(c, target.getOrDefault(c, 0) + 1);
    }
    int left = 0, right = 0;
    int valid = 0, startIdx = 0, minLength = Integer.MAX_VALUE;
    Map<Character, Integer> windows = new HashMap<>();
    while (right < s.length()) {
      char rc = s.charAt(right);
      right++;
      windows.put(rc, windows.getOrDefault(rc, 0) + 1);
      if (target.containsKey(rc)
        && Objects.equals(target.get(rc), windows.get(rc))) {
        valid++;
      }
      while (valid == target.size()) {
        if (right - left < minLength) {
          minLength = right - left;
          startIdx = left;
        }
        char lc = s.charAt(left);
        windows.put(lc, windows.getOrDefault(lc, 0) - 1);
        if (target.containsKey(lc) && windows.get(lc) < target.get(lc)) {
          valid--;
        }
        left++;
      }
    }
    return minLength == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLength);
  }
  // end::answer[]
}
