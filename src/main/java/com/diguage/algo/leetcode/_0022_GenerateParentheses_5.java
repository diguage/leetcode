package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-26 22:35:42
   */
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(2 * n), n, n);
    return result;
  }

  private void backtrack(List<String> result, StringBuilder path, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(path.toString());
      return;
    }
    if (left > 0) {
      path.append('(');
      backtrack(result, path, left - 1, right);
      path.deleteCharAt(path.length() - 1);
    }
    if (right > left) {
      path.append(')');
      backtrack(result, path, left, right - 1);
      path.deleteCharAt(path.length() - 1);
    }
  }

  // end::answer[]
  static void main() {
    new _0022_GenerateParentheses_5().generateParenthesis(3);
  }
}
