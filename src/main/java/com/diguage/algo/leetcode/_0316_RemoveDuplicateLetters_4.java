package com.diguage.algo.leetcode;

public class _0316_RemoveDuplicateLetters_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-11 21:18:39
   */
  public String removeDuplicateLetters(String s) {
    int[] count = new int[26];
    char[] chars = s.toCharArray();
    for (char c : chars) {
      count[c - 'a']++;
    }
    StringBuilder stack = new StringBuilder();
    boolean[] used = new boolean[26];
    for (char c : chars) {
      count[c - 'a']--;
      if (used[c - 'a']) {
        continue;
      }
      while (!stack.isEmpty()
        && stack.charAt(stack.length() - 1) > c
        && count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
        used[stack.charAt(stack.length() - 1) - 'a'] = false;
        stack.deleteCharAt(stack.length() - 1);
      }
      stack.append(c);
      used[c - 'a'] = true;
    }
    return stack.toString();
  }
  // end::answer[]
  static void main() {
    new _0316_RemoveDuplicateLetters_4()
      .removeDuplicateLetters("abacb");
  }
}
