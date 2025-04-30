package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0224_BasicCalculator {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-30 07:42:31
   */
  public int calculate(String s) {
    // 存放所有的数字
    Deque<Integer> nums = new ArrayDeque<>(s.length());
    // 存放所有的操作，包括 +/-
    Deque<Character> ops = new ArrayDeque<>(s.length());
    // 为了防止第一个数为负数，先往 nums 加个 0
    nums.offerLast(0);
    // 将所有的空格去掉
    s = s.replaceAll(" ", "");
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == '(') {
        ops.offerLast(c);
      } else if (c == ')') {
        // 计算到最近一个左括号为止
        while (!ops.isEmpty()) {
          if (ops.peekLast() != '(') {
            calc(nums, ops);
          } else {
            ops.pollLast();
            break;
          }
        }
      } else {
        if (Character.isDigit(c)) {
          int num = c - '0';
          // 将从 i 位置开始后面的连续数字整体取出，加入 nums
          while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
            num = num * 10 + chars[i + 1] - '0';
            i++;
          }
          nums.offerLast(num);
        } else {
          if (i > 0 && (chars[i - 1] == '-' || chars[i - 1] == '+' || chars[i - 1] == '(')) {
            nums.offerLast(0);
          }
          // 有一个新操作要入栈时，先把栈内可以算的都算了
          while (!ops.isEmpty() && ops.peekLast() != '(') {
            calc(nums, ops);
          }
          ops.offerLast(c);
        }
      }
    }
    while (!ops.isEmpty()) {
      calc(nums, ops);
    }
    return nums.peekLast();
  }

  private void calc(Deque<Integer> nums, Deque<Character> ops) {
    if (nums.isEmpty() || nums.size() < 2) {
      return;
    }
    if (ops.isEmpty()) {
      return;
    }
    Integer a = nums.pollLast();
    Integer b = nums.pollLast();
    Character op = ops.pollLast();
    nums.offerLast(op == '+' ? a + b : b - a);
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0224_BasicCalculator().calculate("1-(     -2)");
  }
}
