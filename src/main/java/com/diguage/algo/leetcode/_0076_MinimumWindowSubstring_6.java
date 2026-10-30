package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _0076_MinimumWindowSubstring_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-30 23:06:11
   */
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }
    char[] tc = t.toCharArray();
    Map<Character, Integer> tm = new HashMap<>();
    for (char c : tc) {
      tm.put(c, tm.getOrDefault(c, 0) + 1);
    }
    char[] sc = s.toCharArray();
    Map<Character, Integer> sm = new HashMap<>();
    for (char c : sc) {
      sm.put(c, sm.getOrDefault(c, 0) + 1);
    }
    if (sm.size() < tm.size()) {
      return "";
    }
    for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
      if (!sm.containsKey(entry.getKey()) || sm.get(entry.getKey()) < entry.getValue()) {
        return "";
      }
    }
    Map<Character, Integer> windows = new HashMap<>();
    int valid = 0;
    String result = "";
    int low = 0, fast = 0;
    while (fast < s.length()) {
      char c = sc[fast];
      fast++;
      windows.put(c, windows.getOrDefault(c, 0) + 1);
      if (tm.containsKey(c) && Objects.equals(windows.get(c), tm.get(c))) {
        valid++;
      }
      while (valid >= tm.size()) {
        if (result.isEmpty() || result.length() > fast - low) {
          result = s.substring(low, fast);
        }
        char lc = sc[low];
        windows.put(lc, windows.get(lc) - 1);
        if (tm.containsKey(lc) && windows.get(lc) < tm.get(lc)) {
          valid--;
        }
        low++;
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0076_MinimumWindowSubstring_6()
      .minWindow("ADOBECODEBANC", "ABC");
  }
}
