package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0086_PartitionList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 16:17:29
   */
  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode();
    ListNode smallTail = small;
    ListNode big = new ListNode();
    ListNode bigTail = big;

    while (head != null) {
      if (head.val < x) {
        smallTail.next = head;
        smallTail = smallTail.next;
      } else {
        bigTail.next = head;
        bigTail = bigTail.next;
      }
      head = head.next;
    }
    smallTail.next = big.next;
    bigTail.next = null;
    return small.next;
  }
  // end::answer[]
}
