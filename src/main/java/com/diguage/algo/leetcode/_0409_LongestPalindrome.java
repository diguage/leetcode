package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0409_LongestPalindrome {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 17:32:17
   */
  public int longestPalindrome(String s) {
    Map<Character, Integer> charToCntMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      Integer cnt = charToCntMap.getOrDefault(c, 0);
      charToCntMap.put(c, cnt + 1);
    }
    int result = 0;
    int odd = 0;
    for (Integer value : charToCntMap.values()) {
      result += (value / 2) * 2;
      if (value % 2 == 1) {
        odd = 1;
      }
    }
    return result + odd;
  }
  // end::answer[]
}
