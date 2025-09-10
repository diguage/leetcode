package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0003_LongestSubstringWithoutRepeatingCharacters_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-10 21:18:00
   */
  public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0;
    Map<Character, Integer> counter = new HashMap<>();
    int result = 0;
    while (right < s.length()) {
      char rc = s.charAt(right);
      counter.put(rc, counter.getOrDefault(rc, 0) + 1);
      right++;
      while (counter.get(rc) > 1) {
        char tmp = s.charAt(left);
        Integer cnt = counter.get(tmp);
        if (cnt == 1) {
          counter.remove(tmp);
        } else {
          counter.put(tmp, counter.get(tmp) - 1);
        }
        left++;
      }
      result = Math.max(result, counter.size());
    }
    return result;
  }
  // end::answer[]
}
