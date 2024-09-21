package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0003_LongestSubstringWithoutRepeatingCharacters_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 20:41:51
   */
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int result = 0, left = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      int cnt = map.getOrDefault(c, 0);
      if (cnt == 0) {
        map.put(c, 1);
        result = Math.max(result, right - left + 1);
      } else {
        map.put(c, cnt + 1);
      }
      while (map.get(c) > 1) {
        char lc = s.charAt(left);
        left++;
        map.put(lc, map.get(lc) - 1);
      }
    }
    return result;
  }
  // end::answer[]
}
