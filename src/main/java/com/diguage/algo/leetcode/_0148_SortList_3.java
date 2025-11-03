package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0148_SortList_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-03 20:28:50
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head, fast = head;
    // 注意：这里已经在前面判断过 head == null，所以，肯定 fast != null
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode right = sortList(slow.next);
    slow.next = null;
    ListNode left = sortList(head);
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }
    curr.next = left != null ? left : right;
    return dummy.next;
  }
  // end::answer[]
}
