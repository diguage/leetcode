package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0206_ReverseLinkedList_41 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-02 15:23:04
   */
  public ListNode reverseList(ListNode head) {
    return reverseList(head, null);
  }

  private ListNode reverseList(ListNode head, ListNode pre) {
    if (head == null) {
      return pre;
    }
    ListNode next = head.next;
    ListNode result = reverseList(next, head);
    head.next = pre;
    return result;
  }
  // end::answer[]
}
