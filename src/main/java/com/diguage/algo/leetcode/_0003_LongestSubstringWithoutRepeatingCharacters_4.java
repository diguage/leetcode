package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0003_LongestSubstringWithoutRepeatingCharacters_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-01 17:03:21
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int result = 0;
    Map<Character, Integer> counter = new HashMap<>();
    int left = 0, right = 0;
    char[] chars = s.toCharArray();
    while (right < chars.length) {
      char rc = chars[right];
      right++;
      int cnt = counter.getOrDefault(rc, 0) + 1;
      counter.put(rc, cnt);
      if (cnt == 1) {
        // 这里使用 right - left (right已经++了)更好
        result = Math.max(result, counter.size());
      }
      while (left < chars.length && counter.get(rc) > 1) {
        char lc = chars[left];
        left++;
        int nc = counter.get(lc) - 1;
        if (nc == 0) {
          counter.remove(lc);
        } else {
          counter.put(lc, nc);
        }
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0003_LongestSubstringWithoutRepeatingCharacters_4()
      .lengthOfLongestSubstring("pwwkew");
  }
}
