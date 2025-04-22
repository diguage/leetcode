package com.diguage.algo.leetcode;

public class _1081_SmallestSubsequenceOfDistinctCharacters {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-22 16:54:12
   */
  public String smallestSubsequence(String s) {
    char[] chars = s.toCharArray();
    int[] counts = new int[26];
    for (char c : chars) {
      counts[c - 'a']++;
    }
    boolean[] used = new boolean[26];
    StringBuilder sb = new StringBuilder(26);
    for (char c : chars) {
      int idx = c - 'a';
      counts[idx]--;
      if (used[idx]) {
        continue;
      }
      while (!sb.isEmpty()
        && sb.charAt(sb.length() - 1) > c) {
        int lastIndex = sb.length() - 1;
        int tid = sb.charAt(lastIndex) - 'a';
        if (counts[tid] == 0) {
          break;
        } else {
          sb.deleteCharAt(lastIndex);
          used[tid] = false;
        }
      }
      sb.append(c);
      used[idx] = true;
    }
    return sb.toString();
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1081_SmallestSubsequenceOfDistinctCharacters()
      .smallestSubsequence("bcabc");
  }
}
