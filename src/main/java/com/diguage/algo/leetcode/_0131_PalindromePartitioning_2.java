package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0131_PalindromePartitioning_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 21:17:12
   */
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>(s.length());
    List<String> path = new ArrayList<>(s.length());
    Map<String, Boolean> validMap = new HashMap<>(s.length());
    backtrack(s, 0, result, path, validMap);
    return result;
  }

  private void backtrack(String s, int index, List<List<String>> result,
                         List<String> path, Map<String, Boolean> validMap) {
    if (index >= s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index + 1; i <= s.length(); i++) {
      String sub = s.substring(index, i);
      boolean isValid;
      if (validMap.containsKey(sub)) {
        isValid = validMap.get(sub);
      } else {
        isValid = isPalindrome(sub);
        validMap.put(sub, isValid);
      }
      if (!isValid) {
        continue;
      }
      path.add(sub);
      backtrack(s, i, result, path, validMap);
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
  public static void main(String[] args) {
    new _0131_PalindromePartitioning_2().partition("aab");
  }
}
