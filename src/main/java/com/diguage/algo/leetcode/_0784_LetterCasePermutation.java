package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0784_LetterCasePermutation {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-18 20:51:07
   */
  public List<String> letterCasePermutation(String s) {
    List<String> result = new ArrayList<>();
    backtrack(s.toCharArray(), new StringBuilder(), result);
    return result;
  }

  private void backtrack(char[] chars, StringBuilder path, List<String> result) {
    if (path.length() == chars.length) {
      result.add(path.toString());
      return;
    }
    char c = chars[path.length()];
    if ('0' <= c && c <= '9') {
      path.append(c);
      backtrack(chars, path, result);
      path.deleteCharAt(path.length() - 1);
    } else {
      char[] updown = new char[]{c, (char) (c ^ 0b10_0000)};
      for (char c1 : updown) {
        path.append(c1);
        backtrack(chars, path, result);
        path.deleteCharAt(path.length() - 1);
      }
    }
  }

  // end::answer[]
  static void main() {
    new _0784_LetterCasePermutation().letterCasePermutation("a1b2");
  }
}
