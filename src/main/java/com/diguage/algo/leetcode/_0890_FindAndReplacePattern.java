package com.diguage.algo.leetcode;

import java.util.*;

public class _0890_FindAndReplacePattern {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-24 20:56:15
   */
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder(word);
      Set<Character> set = new HashSet<>();
      Map<Character, String> map = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
        char pc = pattern.charAt(i);
        char wc = word.charAt(i);
        if (!map.containsKey(wc) && !set.contains(pc)) {
          map.put(wc, String.valueOf(pc));
          set.add(pc);
          sb.replace(i, i + 1, map.get(wc));
        } else if (map.containsKey(wc)) {
          sb.replace(i, i + 1, map.get(wc));
        } else {
          break;
        }
      }
      if (sb.toString().equals(pattern)) {
        result.add(word);
      }
    }
    return result;
  }
  // end::answer[]
}
