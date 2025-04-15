package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0019_RemoveNthNodeFromEndOfList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-15 21:26:08
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    while (n >= 0) {
      fast = fast.next;
      n--;
    }
    ListNode pre = dummy;
    ListNode slow = head;
    while (fast != null) {
      fast = fast.next;
      pre = slow;
      slow = slow.next;
    }
    pre.next = slow.next;
    return dummy.next;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0019_RemoveNthNodeFromEndOfList_2()
      .removeNthFromEnd(ListNodes.build(Arrays.asList(1)), 1);
  }
}
