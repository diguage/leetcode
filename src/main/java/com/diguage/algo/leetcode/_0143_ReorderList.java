package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0143_ReorderList {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-13 22:09:48
   */
  public void reorderList(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode reversed = reverse(slow.next, null);
    slow.next = null;
    ListNode next = head.next;
    boolean order = false;
    ListNode curr = head;
    while (next != null && reversed != null) {
      if (order) {
        curr.next = next;
        next = next.next;
      } else {
        curr.next = reversed;
        reversed = reversed.next;
      }
      curr = curr.next;
      order = !order;
    }
    curr.next = next;
  }

  private ListNode reverse(ListNode head, ListNode pre) {
    if (head == null) {
      return pre;
    }
    ListNode result = reverse(head.next, head);
    head.next = pre;
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0143_ReorderList().reorderList(ListNodes.build(Arrays.asList(1, 2, 3, 4, 5)));
  }
}
