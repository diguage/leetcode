package com.diguage.algo.leetcode;

import java.util.Set;
import java.util.StringJoiner;

public class _0824_GoatLatin {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-17 22:31:31
   */
  public String toGoatLatin(String sentence) {
    String[] words = sentence.split(" ");
    StringJoiner joiner = new StringJoiner(" ");
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (set.contains((char) (word.charAt(0) | 0b10_0000))) {
        joiner.add(word + "ma" + "a".repeat(i + 1));
      } else {
        joiner.add(word.substring(1) + word.charAt(0) + "ma" + "a".repeat(i + 1));
      }
    }
    return joiner.toString();
  }
  // end::answer[]
}
