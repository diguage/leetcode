package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-03 21:53:58
   */
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, n, n, new StringBuilder(2 * n));
    return result;
  }

  private void backtrack(List<String> result,
                         int left, int right, StringBuilder sb) {
    if (left < 0 || right < 0 || left > right) {
      return;
    }
    if (left == 0 && right == 0) {
      result.add(sb.toString());
      return;
    }
    if (left > 0) {
      sb.append("(");
      backtrack(result, left - 1, right, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (right > left) {
      sb.append(")");
      backtrack(result, left, right - 1, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
  // end::answer[]

  static void main() {
    new _0022_GenerateParentheses_4()
      .generateParenthesis(1);
  }
}
