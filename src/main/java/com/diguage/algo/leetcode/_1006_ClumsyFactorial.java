package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiFunction;

public class _1006_ClumsyFactorial {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-23 14:54:02
   */
  public int clumsy(int n) {
    char[] operators = new char[]{'*', '/', '+', '-'};
    BiFunction<Integer, Integer, Integer>[] ops = new BiFunction[4];
    ops[0] = (x, y) -> x * y;
    ops[1] = (x, y) -> x / y;
    ops[2] = Integer::sum;
    ops[3] = (x, y) -> x - y;
    int idx = 0;
    int result = 0;
    Deque<Integer> stack = new ArrayDeque<>(n);
    stack.offer(n--);
    while (!stack.isEmpty() && n > 0) {
      if (idx == 2 && stack.size() == 2) {
        Integer b = stack.pollLast();
        Integer a = stack.pollLast();
        stack.offer(ops[3].apply(a, b));
        continue;
      }
      if (idx == 0 || idx == 1 || idx == 2) {
        Integer pre = stack.pollLast();
        Integer res = ops[idx].apply(pre, n--);
        stack.offerLast(res);
      } else {
        stack.offerLast(n--);
      }
      idx++;
      idx %= operators.length;
    }
    if (stack.size() == 1) {
      result = stack.pollLast();
    } else {
      Integer b = stack.pollLast();
      Integer a = stack.pollLast();
      result = ops[3].apply(a, b);
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1006_ClumsyFactorial().clumsy(4);
  }
}
