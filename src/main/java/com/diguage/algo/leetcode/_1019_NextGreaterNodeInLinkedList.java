package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _1019_NextGreaterNodeInLinkedList {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-01 21:03:55
   */
  public int[] nextLargerNodes(ListNode head) {
    List<Integer> nums = new ArrayList<>();
    while (head != null) {
      nums.add(head.val);
      head = head.next;
    }
    int[] result = new int[nums.size()];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < nums.size(); i++) {
      while (!stack.isEmpty() && nums.get(stack.peek()) <= nums.get(i)) {
        result[stack.pop()] = nums.get(i);
      }
      stack.push(i);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _1019_NextGreaterNodeInLinkedList().nextLargerNodes(ListNodes.build(2, 7, 4, 3, 5));
  }
}
