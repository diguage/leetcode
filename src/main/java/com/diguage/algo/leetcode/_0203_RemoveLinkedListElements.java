package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.List;

public class _0203_RemoveLinkedListElements {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 16:53:21
   */
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = head;
    while (fast != null) {
      if (fast.val == val) {
        slow.next = fast.next;
      } else {
        slow = slow.next;
      }
      fast = fast.next;
    }
    slow.next = null;
    return dummy.next;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0203_RemoveLinkedListElements()
      .removeElements(ListNodes.build(List.of(1, 2, 6, 3, 4, 5, 6)), 6);
  }
}
