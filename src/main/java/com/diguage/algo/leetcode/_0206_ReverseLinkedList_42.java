package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0206_ReverseLinkedList_42 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-02 15:39:16
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
  // end::answer[]
}
