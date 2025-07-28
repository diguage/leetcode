package com.diguage.algo.leetcode;

public class _0389_FindTheDifference {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-28 22:04:04
   */
  public char findTheDifference(String s, String t) {
    int[] chars = new int[26];
    for (char c : t.toCharArray()) {
      chars[c - 'a']++;
    }
    for (char c : s.toCharArray()) {
      chars[c - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (chars[i] != 0) {
        return (char) (i + 'a');
      }
    }
    return 0;
  }
  // end::answer[]
}
