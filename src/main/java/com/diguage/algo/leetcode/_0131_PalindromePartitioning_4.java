package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0131_PalindromePartitioning_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-14 22:41:15
   */
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    backtrack(s, 0, result, path);
    return result;
  }

  public void backtrack(String s, int index, List<List<String>> result, List<String> path) {
    if (index >= s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index + 1; i <= s.length(); i++) {
      String sub = s.substring(index, i);
      if (!isPalindrome(sub)) {
        continue;
      }
      path.add(sub);
      backtrack(s, i, result, path);
      path.removeLast();
    }
  }

  private boolean isPalindrome(String s) {
    int low = 0, high = s.length() - 1;
    while (low < high) {
      if (s.charAt(low++) != s.charAt(high--)) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]

  static void main() {
    new _0131_PalindromePartitioning_4().partition("aab");
  }
}
