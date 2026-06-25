package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0792_NumberOfMatchingSubsequences {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-07 21:52:04
   */
  public int numMatchingSubseq(String s, String[] words) {
    int result = 0;
    Map<String, Integer> counter = new HashMap<>();
    for (String word : words) {
      counter.put(word, counter.getOrDefault(word, 0) + 1);
    }
    for (Map.Entry<String, Integer> entry : counter.entrySet()) {
      String word = entry.getKey();
      int si = 0, wi = 0;
      while (si < s.length() && wi < word.length()) {
        if (s.charAt(si) == word.charAt(wi)) {
          wi++;
        }
        si++;
      }
      if (wi == word.length()) {
        result += entry.getValue();
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0792_NumberOfMatchingSubsequences()
      .numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
  }
}
