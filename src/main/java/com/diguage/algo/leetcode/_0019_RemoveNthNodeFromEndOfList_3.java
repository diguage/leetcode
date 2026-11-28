package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0019_RemoveNthNodeFromEndOfList_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-28 22:45:11
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    while (n > 0 && fast.next != null) {
      fast = fast.next;
      n--;
    }
    ListNode slow = dummy;
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
  // end::answer[]
}
