package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0142_LinkedListCycleII_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 17:02:00
   */
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next;
      fast = fast.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
      if (slow == fast) {
        break;
      }
    }
    return slow;
  }
  // end::answer[]
}
