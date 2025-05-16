package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-16 23:23:48
   */
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder(n * 2);
    backtrack(n, n, result, path);
    return result;
  }

  private void backtrack(int left, int right,
                         List<String> result, StringBuilder path) {
    if (left == 0 && right == 0) {
      result.add(path.toString());
      return;
    }
    // left < 0 表示已经添加了超量的左括号
    // left > right 表示右括号数量大于左括号
    if (left < 0 || left > right) {
      return;
    }
    char[] chars = {'(', ')'};
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      path.append(c);
      if (i == 0) {
        backtrack(left - 1, right, result, path);
      } else {
        backtrack(left, right - 1, result, path);
      }
      path.deleteCharAt(path.length() - 1);
    }
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0022_GenerateParentheses_2()
      .generateParenthesis(3);
  }
}
