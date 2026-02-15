package com.diguage.algo.leetcode;

import java.util.*;

public class _0500_KeyboardRow {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-15 23:13:50
   */
  public String[] findWords(String[] words) {
    String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    Map<Character, Integer> charToIndex = new HashMap<>();
    for (int i = 0; i < lines.length; i++) {
      for (char c : lines[i].toCharArray()) {
        charToIndex.put(c, i);
      }
    }
    List<String> result = new ArrayList<>();
    for (String word : words) {
      boolean ok = true;
      int line = -1;
      for (char c : word.toLowerCase().toCharArray()) {
        if (line == -1) {
          line = charToIndex.get(c);
          continue;
        }
        if (charToIndex.get(c) != line) {
          ok = false;
          break;
        }
      }
      if (ok) {
        result.add(word);
      }
    }
    return result.toArray(new String[0]);
  }
  // end::answer[]
}
