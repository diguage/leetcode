package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049_GroupAnagrams_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-26 17:08:52
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Map<Character, Integer> key = new HashMap<>();
      for (char c : chars) {
        key.put(c, key.getOrDefault(c, 0) + 1);
      }
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    List<List<String>> result = new ArrayList<>(map.size());
    result.addAll(map.values());
    return result;
  }
  // end::answer[]
}
