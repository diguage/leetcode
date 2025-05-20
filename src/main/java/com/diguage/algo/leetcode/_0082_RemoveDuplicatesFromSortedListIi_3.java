package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0082_RemoveDuplicatesFromSortedListIi_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-20 14:39:15
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(119);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode slow = head;
    ListNode fast = head;
    boolean flag = false;
    while (fast != null) {
      if (fast.val == slow.val) {
        if (fast != slow) {
          flag = true;
        }
        fast = fast.next;
      } else {
        if (flag) {
          pre.next = fast;
          slow = fast;
          flag = false;
        } else {
          pre = pre.next;
          slow = slow.next;
          fast = fast.next;
        }
      }
    }
    if (flag) {
      pre.next = fast;
    }
    return dummy.next;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0082_RemoveDuplicatesFromSortedListIi_3()
      .deleteDuplicates(ListNodes.build(Arrays.asList(1, 1)));
  }
}
