package com.diguage.algo.leetcode;

import java.util.*;

public class _0438_FindAllAnagramsInAString_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-13 19:14:34
   */
  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> counter = new HashMap<>();
    for (char c : p.toCharArray()) {
      counter.put(c, counter.getOrDefault(c, 0) + 1);
    }
    Map<Character, Integer> window = new HashMap<>();
    int slow = 0, fast = 0;
    List<Integer> result = new ArrayList<>();
    while (fast < s.length()) {
      char c = s.charAt(fast);
      if (counter.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
      }
      while (fast - slow + 1 >= p.length()) {
        if (Objects.equals(counter, window)) {
          result.add(slow);
        }
        char sc = s.charAt(slow);
        if (window.containsKey(sc)) {
          Integer cnt = window.get(sc);
          if (cnt == 1) {
            window.remove(sc);
          } else {
            window.put(sc, cnt - 1);
          }
        }
        slow++;
      }
      fast++;
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0438_FindAllAnagramsInAString_3()
      .findAnagrams("abaacbabc", "abc");
  }
}
