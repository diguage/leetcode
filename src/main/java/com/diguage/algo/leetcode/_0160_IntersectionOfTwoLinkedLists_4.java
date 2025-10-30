package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0160_IntersectionOfTwoLinkedLists_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-30 21:33:00
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode ha = headA, hb = headB;
    while (ha != hb) { // 如果不相交，则最后都会走到 null，也会退出循环
      ha = ha == null ? headB : ha.next;
      hb = hb == null ? headA : hb.next;
    }
    return ha;
  }
  // end::answer[]
}
