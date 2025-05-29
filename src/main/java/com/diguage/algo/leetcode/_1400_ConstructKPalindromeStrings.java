package com.diguage.algo.leetcode;

public class _1400_ConstructKPalindromeStrings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-29 21:41:04
   */
  public boolean canConstruct(String s, int k) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    int even = 0;
    for (int i = 0; i < 26; i++) {
      if (count[i] % 2 == 1) {
        even++;
      }
    }
    int left = Math.max(1, even);
    return left <= k && k <= s.length();
  }
  // end::answer[]
}
