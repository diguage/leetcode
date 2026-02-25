package com.diguage.algo.leetcode;

import java.util.Comparator;
import java.util.List;

public class _0524_LongestWordInDictionaryThroughDeleting {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-25 20:34:08
   */
  public String findLongestWord(String s, List<String> dictionary) {
    dictionary.sort(Comparator
      .comparingInt(String::length)
      .reversed()
      .thenComparing(Comparator.naturalOrder()));
    char[] chars = s.toCharArray();
    for (String d : dictionary) {
      if (isSequence(d.toCharArray(), chars)) {
        return d;
      }
    }
    return "";
  }

  private boolean isSequence(char[] sub, char[] chars) {
    int i = 0;
    for (char c : chars) {
      if (sub[i] == c && ++i == sub.length) {
        return true;
      }
    }
    return false;
  }
  // end::answer[]
}
