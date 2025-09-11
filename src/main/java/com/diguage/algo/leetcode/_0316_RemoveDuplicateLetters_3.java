package com.diguage.algo.leetcode;

public class _0316_RemoveDuplicateLetters_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-11 21:13:45
   */
  public String removeDuplicateLetters(String s) {
    char[] chars = s.toCharArray();
    int[] counter = new int[26];
    for (char c : chars) {
      counter[c - 'a']++;
    }
    boolean[] added = new boolean[26];
    StringBuilder result = new StringBuilder();
    for (char c : chars) {
      int idx = c - 'a';
      counter[c - 'a']--;
      if (added[idx]) {
        continue;
      }
      while (!result.isEmpty() && result.charAt(result.length() - 1) > c) {
        int lastIdx = result.charAt(result.length() - 1) - 'a';
        if (counter[lastIdx] == 0) {
          break;
        }
        result.deleteCharAt(result.length() - 1);
        added[lastIdx] = false;
      }
      result.append(c);
      added[idx] = true;
    }
    return result.toString();
  }
  // end::answer[]
}
