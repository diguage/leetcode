package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * = 567. Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/[Permutation in String - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 17:19:45
 */
public class _0567_PermutationInString_2 {
  /**
   * 自己实现
   */
  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s1.isEmpty()
      || s2 == null || s2.isEmpty()
      || s2.length() < s1.length()) {
      return false;
    }
    Map<Character, Integer> need = new HashMap<>();
    for (char c : s1.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    Map<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int valid = 0;
    while (right < s2.length()) {
      char rc = s2.charAt(right);
      right++;
      if (need.containsKey(rc)) {
        window.put(rc, window.getOrDefault(rc, 0) + 1);
        if (window.get(rc).equals(need.get(rc))) {
          valid++;
        }
      }
      while (need.size() == valid) {
        if (right - left == s1.length()) {
          return true;
        }
        char lc = s2.charAt(left);
        if (window.containsKey(lc)) {
          window.put(lc, window.get(lc) - 1);
          if (window.get(lc) < need.get(lc)) {
            valid--;
          }
        }
        left++;
      }
    }
    return false;
  }
}
