package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0160_IntersectionOfTwoLinkedLists_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-02 21:37:57
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      if (a == null) {
        a = headB;
      } else {
        a = a.next;
      }
      if (b == null) {
        b = headA;
      } else {
        b = b.next;
      }
    }
    return a;
  }
  // end::answer[]
}
