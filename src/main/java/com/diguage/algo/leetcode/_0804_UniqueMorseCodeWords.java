package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0804_UniqueMorseCodeWords {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-30 21:42:07
   */
  public int uniqueMorseRepresentations(String[] words) {
    String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
      "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
      ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    Set<String> set = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        sb.append(MORSE[c - 'a']);
      }
      set.add(sb.toString());
    }
    return set.size();
  }
  // end::answer[]
}
