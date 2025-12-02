package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0024_SwapNodesInPairs_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-02 21:13:27
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = swapPairs(head.next.next);
    ListNode second = head.next;
    second.next = head;
    head.next = tail;
    return second;
  }
  // end::answer[]
}
