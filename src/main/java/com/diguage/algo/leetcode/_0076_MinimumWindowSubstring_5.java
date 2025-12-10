package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0076_MinimumWindowSubstring_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-10 22:13:38
   */
  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int slow = 0, fast = 0;
    char[] chars = s.toCharArray();
    Map<Character, Integer> counter = new HashMap<>();
    int valid = 0;
    String result = "";
    while (fast < s.length()) {
      char c = chars[fast++];
      if (map.containsKey(c)) {
        int cnt = counter.getOrDefault(c, 0) + 1;
        counter.put(c, cnt);
        if (cnt == map.get(c)) {
          valid++;
        }
      }
      while (valid == map.size()) {
        if (result.isEmpty() || fast - slow < result.length()) {
          result = s.substring(slow, fast);
        }
        char sc = chars[slow++];
        if (map.containsKey(sc)) {
          int cnt = counter.getOrDefault(sc, 0);
          if (cnt == map.get(sc)) {
            valid--;
          }
          counter.put(sc, cnt - 1);
        }
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0076_MinimumWindowSubstring_5().minWindow("a", "aa");
  }
}
