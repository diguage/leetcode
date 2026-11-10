package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049_GroupAnagrams_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-10 23:09:35
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    for (String str : strs) {
      Map<Character, Integer> cnt = new HashMap<>();
      for (char c : str.toCharArray()) {
        cnt.put(c, cnt.getOrDefault(c, 0) + 1);
      }
      map.computeIfAbsent(cnt, _ -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }
  // end::answer[]
}
