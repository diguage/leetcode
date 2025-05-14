package com.diguage.algo.leetcode;

public class _1839_LongestSubstringOfAllVowelsInOrder {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-13 21:48:41
   */
  public int longestBeautifulSubstring(String word) {
    int result = 0;
    int cnt = 0;
    char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
    int idx = -1;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (i == 0) {
        if (c == 'a') {
          cnt = 1;
          idx = 0;
        }
      } else {
        if (word.charAt(i - 1) > c) {
          if (c == 'a') {
            cnt = 1;
            idx = 0;
          } else {
            cnt = 0;
            idx = -1;
          }
        } else {
          if (idx >= 0) {
            if (c == chars[idx]) {
              cnt++;
            } else if (idx < chars.length - 1 && c == chars[idx + 1]) {
              idx++;
              cnt++;
            } else {
              cnt = 0;
              idx = -1;
            }
          }
        }
      }
      if (idx == chars.length - 1) {
        result = Math.max(result, cnt);
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1839_LongestSubstringOfAllVowelsInOrder()
      .longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
  }
}
