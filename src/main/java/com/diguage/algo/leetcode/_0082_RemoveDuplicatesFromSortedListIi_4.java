package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

public class _0082_RemoveDuplicatesFromSortedListIi_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-08 19:31:46
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode curr = dummy;
    while (curr.next != null && curr.next.next != null) {
      if (curr.next.val == curr.next.next.val) {
        int val = curr.next.val;
        while (curr.next != null && curr.next.val == val) {
          curr.next = curr.next.next;
        }
      } else {
        curr = curr.next;
      }
    }
    return dummy.next;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0082_RemoveDuplicatesFromSortedListIi_4()
      .deleteDuplicates(ListNodes.build(1, 2, 3, 3, 4, 4, 5));
  }
}
