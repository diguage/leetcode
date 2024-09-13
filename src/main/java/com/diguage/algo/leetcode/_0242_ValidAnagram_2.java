package com.diguage.algo.leetcode;

public class _0242_ValidAnagram_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-10 23:48
   */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] chars = new int[26];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      chars[c - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      chars[c - 'a']--;
      if (chars[c - 'a'] < 0) {
        return false;
      }
    }
    for (int cnt : chars) {
      if (cnt != 0) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
