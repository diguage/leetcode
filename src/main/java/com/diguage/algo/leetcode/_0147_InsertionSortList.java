package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0147_InsertionSortList {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-26 21:56:34
   */
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null) {
      ListNode curr = prev.next;
      if (curr.val < prev.val) {
        prev.next = curr.next;
        ListNode first = dummy;
        while (first.next.val < curr.val) {
          first = first.next;
        }
        curr.next = first.next;
        first.next = curr;
      } else {
        prev = prev.next;
      }
    }
    return dummy.next;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0147_InsertionSortList().insertionSortList(
      ListNodes.build(Arrays.asList(4, 2, 1, 3)));
  }
}
