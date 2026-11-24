package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0024_SwapNodesInPairs_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-24 23:29:37
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode b = head.next;
    ListNode c = b.next;
    b.next = head;
    head.next = swapPairs(c);
    return b;
  }
  // end::answer[]
}
