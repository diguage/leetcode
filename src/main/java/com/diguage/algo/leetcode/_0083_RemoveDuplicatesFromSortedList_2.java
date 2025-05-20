package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0083_RemoveDuplicatesFromSortedList_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-20 15:08:29
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(119);
    dummy.next = head;
    ListNode curr = dummy;
    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        int val = curr.val;
        while (curr.next != null && val == curr.next.val) {
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
    new _0083_RemoveDuplicatesFromSortedList_2()
      .deleteDuplicates(ListNodes.build(Arrays.asList(1, 1, 2, 3, 3)));
  }
}
