package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Objects;

public class _0160_IntersectionOfTwoLinkedLists_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-30 21:33:00
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode ha = headA, hb = headB;
    boolean fa = true, fb = true; // 如果不加标注，则会陷入死循环。
    while (ha != null && hb != null) {
      if (Objects.equals(ha, hb)) {
        return ha;
      }
      ha = ha.next;
      hb = hb.next;
      if (fa && Objects.isNull(ha)) {
        ha = headB;
        fa = false;
      }
      if (fb && Objects.isNull(hb)) {
        hb = headA;
        fb = false;
      }
    }
    return null;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0160_IntersectionOfTwoLinkedLists_4()
      .getIntersectionNode(
        ListNodes.build(4, 1, 8, 4, 5),
        ListNodes.build(5, 6, 1, 8, 4, 5));
  }
}
