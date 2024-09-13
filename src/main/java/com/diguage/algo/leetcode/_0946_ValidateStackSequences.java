package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0946_ValidateStackSequences {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 20:29:14
   */
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Deque<Integer> stack = new LinkedList<>();
    int oi = 0;
    for (int i = 0; i < pushed.length; i++) {
      int inum = pushed[i];
      stack.addLast(inum);
      while (!stack.isEmpty() && stack.peekLast() == popped[oi]) {
        stack.removeLast();
        oi++;
      }
    }
    return stack.isEmpty();
  }
  // end::answer[]
}
