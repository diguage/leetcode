package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0735_AsteroidCollision {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-02 23:02:33
   */
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int a : asteroids) {
      if (stack.isEmpty()
        || stack.peek() < 0 && a < 0
        || stack.peek() > 0 && a > 0
        || stack.peek() < 0 && a > 0) {
        stack.push(a);
        continue;
      }
      while (a != 0 && !stack.isEmpty()) {
        if (!(stack.peek() > 0 && a < 0)) {
          break;
        }
        if (Math.abs(stack.peek()) == Math.abs(a)) {
          a = 0;
          stack.pop();
        } else if (Math.abs(stack.peek()) > Math.abs(a)) {
          a = 0;
        } else {
          stack.pop();
        }
      }
      if (a != 0) {
        stack.push(a);
      }
    }
    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0735_AsteroidCollision().asteroidCollision(new int[]{5, 10, -5});
  }
}
