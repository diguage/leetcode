package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1189_MaximumNumberOfBalloons {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-21 21:23:20
   */
  public int maxNumberOfBalloons(String text) {
    String s = "balloon";
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    Map<Character, Integer> cnt = new HashMap<>();
    for (char c : text.toCharArray()) {
      if (map.containsKey(c)) {
        cnt.put(c, cnt.getOrDefault(c, 0) + 1);
      }
    }
    if (cnt.keySet().size() < 5) {
      return 0;
    }
    cnt.put('l', cnt.getOrDefault('l', 0) / 2);
    cnt.put('o', cnt.getOrDefault('o', 0) / 2);
    return cnt.values().stream().mapToInt(i -> (int) i).min().getAsInt();
  }
  // end::answer[]
}
