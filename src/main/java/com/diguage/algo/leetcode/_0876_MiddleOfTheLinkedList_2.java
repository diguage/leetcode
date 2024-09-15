package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0876_MiddleOfTheLinkedList_2 {
  // tag::answer[]
  /**
   * 快慢指针
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 23:20:35
   */
  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  // end::answer[]
}
