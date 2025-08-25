package com.diguage.algo.leetcode;

public class _0459_RepeatedSubstringPattern {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-25 21:59:15
   */
  public boolean repeatedSubstringPattern(String s) {
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    int min = s.length();
    for (int i : cnt) {
      if (i == 0) {
        continue;
      }
      min = Math.min(min, i);
    }
    if (min < 2) {
      return false;
    }
    for (int i = 2; i <= min; i++) {
      if (s.length() % i != 0) {
        continue;
      }
      int plen = s.length() / i;
      String substring = s.substring(0, plen);
      boolean repeated = true;
      for (int j = plen; j < s.length(); j += plen) {
        if (!substring.equals(s.substring(j, j + plen))) {
          repeated = false;
          break;
        }
      }
      if (repeated) {
        return true;
      }
    }
    return false;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0459_RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc");
  }
}
