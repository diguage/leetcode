package com.diguage.algo.leetcode;

import java.util.*;

public class _0451_SortCharactersByFrequency {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-21 22:19:12
   */
  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    SequencedMap<Character, Integer> sort = new TreeMap<>(
      (a, b) -> {
        Integer ca = map.get(a);
        Integer cb = map.get(b);
        if (Objects.equals(ca, cb)) {
          return Character.compare(a, b);
        } else {
          return Integer.compare(cb, ca);
        }
      });
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      sort.put(entry.getKey(), entry.getValue());
    }
    StringBuilder sb = new StringBuilder(s.length());
    for (Map.Entry<Character, Integer> entry : sort.entrySet()) {
      for (int i = 0; i < entry.getValue(); i++) {
        sb.append(entry.getKey());
      }
    }
    return sb.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0451_SortCharactersByFrequency().frequencySort("tree");
  }
}
