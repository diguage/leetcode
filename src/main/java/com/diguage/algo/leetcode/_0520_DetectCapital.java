package com.diguage.algo.leetcode;

public class _0520_DetectCapital {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-22 21:46:58
   */
  public boolean detectCapitalUse(String word) {
    int count = 0;
    int index = -1;
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (Character.isUpperCase(c)) {
        count++;
        if (index < 0) {
          index = i;
        }
      }
    }
    return count == 0 || (count == 1 && index == 0) || count == word.length();
  }
  // end::answer[]
}
