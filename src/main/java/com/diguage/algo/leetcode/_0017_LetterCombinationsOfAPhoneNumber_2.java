package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class _0017_LetterCombinationsOfAPhoneNumber_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-04 21:56:19
   */
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    Map<Character, char[]> map = Map.of(
      '2', new char[]{'a', 'b', 'c'},
      '3', new char[]{'d', 'e', 'f'},
      '4', new char[]{'g', 'h', 'i'},
      '5', new char[]{'j', 'k', 'l'},
      '6', new char[]{'m', 'n', 'o'},
      '7', new char[]{'p', 'q', 'r', 's'},
      '8', new char[]{'t', 'u', 'v'},
      '9', new char[]{'w', 'x', 'y', 'z'}
    );
    StringBuilder path = new StringBuilder();
    backtrack(result, digits.toCharArray(), 0, map, path);
    return result;
  }

  private void backtrack(List<String> result, char[] chars, int index,
                         Map<Character, char[]> map, StringBuilder path) {
    if (chars.length - index + path.length() < chars.length) {
      return;
    }
    if (path.length() == chars.length) {
      result.add(path.toString());
    }
    for (int i = index; i < chars.length; i++) {
      for (char c : map.get(chars[i])) {
        path.append(c);
        backtrack(result, chars, i + 1, map, path);
        path.deleteCharAt(path.length() - 1);
      }
    }
  }
  // end::answer[]
}
