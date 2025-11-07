package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0131_PalindromePartitioning_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-07 21:47:00
   */
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    backtrack(s, 0, path, result);
    return result;
  }

  private void backtrack(String s, int index, List<String> path, List<List<String>> result) {
    if (index == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index + 1; i <= s.length(); i++) {
      String part = s.substring(index, i);
      if (!isPalindrome(part)) {
        continue;
      }
      path.add(part);
      backtrack(s, i, path, result);
      path.removeLast();
    }
  }

  private boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  // end::answer[]
}
