package com.diguage.algo.leetcode;

public class _0680_ValidPalindromeIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-10 22:05:20
   */
  public boolean validPalindrome(String s) {
    return dfs(s.toCharArray(), 0, s.length() - 1, 1);
  }

  private boolean dfs(char[] chars, int start, int end, int cnt) {
    if (cnt < 0) {
      return false;
    }
    if (chars[start] != chars[end] && cnt == 0) {
      return false;
    }
    while (start < end) {
      if (chars[start] == chars[end]) {
        start++;
        end--;
      } else {
        return dfs(chars, start + 1, end, cnt - 1)
          || dfs(chars, start, end - 1, cnt - 1);
      }
    }
    return true;
  }

  // end::answer[]
  static void main() {
    new _0680_ValidPalindromeIi().validPalindrome("zryxeededexyz");
  }
}
