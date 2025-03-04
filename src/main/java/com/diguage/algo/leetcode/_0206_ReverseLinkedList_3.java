package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0206_ReverseLinkedList_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 16:24:00
   */
  public ListNode reverseList(ListNode head) {
    return reverseList(head, null);
  }

  private ListNode reverseList(ListNode head, ListNode pre) {
    if (head == null) {
      return head;
    }
    ListNode result = reverseList(head.next, head);
    head.next = pre;
    return result;
  }
  // end::answer[]
}
