package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0141_LinkedListCycle_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-06 21:23:36
   */
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
  // end::answer[]
}
