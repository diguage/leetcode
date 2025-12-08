package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Arrays;

import static com.diguage.util.ListNodes.build;

public class _0206_ReverseLinkedList_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-08 21:47:00
   */
  public ListNode reverseList(ListNode head) {
    return reverseList(head, null);
  }

  private ListNode reverseList(ListNode head, ListNode pre) {
    if (head == null) {
      return pre;
    }
    ListNode result = reverseList(head.next, head);
    head.next = pre;
    return result;
  }
  // end::answer[]

  static void main() {
    _0206_ReverseLinkedList_5 solution = new _0206_ReverseLinkedList_5();
    ListNode result = solution.reverseList(build(Arrays.asList(1, 2, 3, 4, 5)));
    System.out.println(result);
  }
}
