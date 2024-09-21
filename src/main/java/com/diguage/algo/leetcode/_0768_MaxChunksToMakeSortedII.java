package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0768_MaxChunksToMakeSortedII {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 17:48:21
   */
  public int maxChunksToSorted(int[] arr) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int num : arr) {
      if (!stack.isEmpty() && num < stack.peek()) {
        int head = stack.pop();
        while (!stack.isEmpty() && num < stack.peek()) {
          stack.pop();
        }
        stack.push(head);
      } else {
        stack.push(num);
      }
    }
    return stack.size();
  }
  // end::answer[]
}
