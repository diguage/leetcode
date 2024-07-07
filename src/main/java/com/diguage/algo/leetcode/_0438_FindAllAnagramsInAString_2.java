package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 438. Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/[Find All Anagrams in a String - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 17:52:50
 */
public class _0438_FindAllAnagramsInAString_2 {
  // tag::answer[]
  public List<Integer> findAnagrams(String s, String p) {
    if (s == null || s.isEmpty()
      || p == null || p.isEmpty()
      || s.length() < p.length()) {
      return Collections.emptyList();
    }
    Map<Character, Integer> need = new HashMap<>();
    for (char c : p.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    Map<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int valid = 0;
    List<Integer> result = new ArrayList<>();
    while (right < s.length()) {
      char rc = s.charAt(right);
      right++;
      if (need.containsKey(rc)) {
        window.put(rc, window.getOrDefault(rc, 0) + 1);
        if (window.get(rc).equals(need.get(rc))) {
          valid++;
        }
      }
      while (valid == need.size()) {
        if (right - left == p.length()) {
          result.add(left);
        }
        char lc = s.charAt(left);
        if (need.containsKey(lc)) {
          window.put(lc, window.get(lc) - 1);
          if (window.get(lc) < need.get(lc)) {
            valid--;
          }
        }
        left++;
      }
    }
    return result;
  }
  // end::answer[]
}
