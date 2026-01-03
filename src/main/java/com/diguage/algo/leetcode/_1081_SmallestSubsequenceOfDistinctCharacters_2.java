package com.diguage.algo.leetcode;

public class _1081_SmallestSubsequenceOfDistinctCharacters_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 19:59:24
   */
  public String smallestSubsequence(String s) {
    int[] counter = new int[26];
    char[] chars = s.toCharArray();
    for (char c : chars) {
      counter[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder(counter.length);
    boolean[] used = new boolean[counter.length];
    for (char c : chars) {
      int index = c - 'a';
      counter[index]--;
      if (used[index]) {
        continue;
      }
      while (!sb.isEmpty()) {
        char ec = sb.charAt(sb.length() - 1);
        if (ec <= c || counter[ec - 'a'] == 0) {
          break;
        }
        sb.deleteCharAt(sb.length() - 1);
        used[ec - 'a'] = false;
      }
      sb.append(c);
      used[index] = true;
    }
    return sb.toString();
  }
  // end::answer[]
}
