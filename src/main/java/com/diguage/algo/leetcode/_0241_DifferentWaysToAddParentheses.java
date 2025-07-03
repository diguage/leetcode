package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0241_DifferentWaysToAddParentheses {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-03 22:37:01
   */
  public List<Integer> diffWaysToCompute(String expression) {
    int length = expression.length();
    List<Integer> result = new ArrayList<>();
    int start = 0;
    while (start < length) {
      if (Character.isDigit(expression.charAt(start))) {
        start++;
      } else {
        break;
      }
    }
    if (start >= length) {
      result.add(Integer.valueOf(expression));
      return result;
    }
    for (int i = start; i < length; i++) {
      if (Character.isDigit(expression.charAt(i))) {
        continue;
      }
      List<Integer> left = diffWaysToCompute(expression.substring(0, i));
      List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
      char op = expression.charAt(i);
      for (Integer l : left) {
        for (Integer r : right) {
          if (op == '+') {
            result.add(l + r);
          } else if (op == '-') {
            result.add(l - r);
          } else if (op == '*') {
            result.add(l * r);
          }
        }
      }
    }
    return result;
  }
  // end::answer[]
}
