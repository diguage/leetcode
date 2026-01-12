package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0224_BasicCalculator_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-12 22:00:50
   */
  public int calculate(String s) {
    Deque<Integer> ops = new ArrayDeque<>();
    ops.push(1);
    int sign = 1;
    int result = 0;
    int n = s.length();
    int i = 0;
    while (i < n) {
      char c = s.charAt(i);
      if (c == ' ') {
        i++;
      } else if (c == '+') {
        sign = ops.peek();
        i++;
      } else if (c == '-') {
        sign = -ops.peek();
        i++;
      } else if (c == '(') {
        ops.push(sign);
        i++;
      } else if (c == ')') {
        ops.pop();
        i++;
      }else {
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
          num = 10 * num + (s.charAt(i) - '0');
          i++;
        }
        result += sign * num;
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0224_BasicCalculator_2()
      .calculate("(1+(4+5+2)-3)+(6+8)");
//      .calculate("1-(     -2)");
//      .calculate("1+1");
  }
}
