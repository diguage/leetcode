package com.diguage.algo.leetcode;

public class _1400_ConstructKPalindromeStrings_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-28 21:58:37
   */
  public boolean canConstruct(String s, int k) {
    if (k > s.length()) {
      return false;
    }
    int[] chars = new int[26];
    for (char c : s.toCharArray()) {
      chars[c - 'a']++;
    }
    int odd = 0;
    for (int n : chars) {
      if ((n & 1) == 1) {
        odd++;
      }
    }
    return odd == 0 || odd <= k;
  }
  // end::answer[]
}
