package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 20:22:30
 */
public class _0876_MiddleOfTheLinkedList {
  // tag::answer[]
  /**
   * 快慢指针
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-02 20:22:30
   */
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return fast.next == null ? slow : slow.next;
  }
  // end::answer[]
}
