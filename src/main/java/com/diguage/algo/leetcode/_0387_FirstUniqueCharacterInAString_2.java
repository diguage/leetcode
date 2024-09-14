package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0387_FirstUniqueCharacterInAString_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-11 10:48
   */
  public int firstUniqChar(String s) {
    int[] cnt = new int[26];
    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';
      cnt[idx]++;
    }
    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';
      if (cnt[idx] == 1) {
        return i;
      }
    }
    return -1;
  }
  // end::answer[]
}
