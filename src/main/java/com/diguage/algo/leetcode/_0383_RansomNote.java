package com.diguage.algo.leetcode;

public class _0383_RansomNote {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-16 21:06:39
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
    int[] magazineChars = calcChars(magazine);
    for (char c : ransomNote.toCharArray()) {
      magazineChars[c - 'a']--;
      if (magazineChars[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }

  private int[] calcChars(String string) {
    int[] result = new int[26];
    for (char c : string.toCharArray()) {
      result[c - 'a']++;
    }
    return result;
  }
  // end::answer[]
}
