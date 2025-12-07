package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

public class _0002_AddTwoNumbers_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-07 22:25:58
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int car = 0;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (l1 != null || l2 != null || car != 0) {
      if (l1 == null && l2 == null) {
        curr.next = new ListNode(car);
        break;
      }
      if (l1 == null) {
        l1 = l2;
        l2 = null;
      }
      int sum = l1.val + (l2 == null ? 0 : l2.val) + car;
      car = sum / 10;
      l1.val = sum % 10;
      curr.next = l1;
      curr = l1;
      l1 = l1.next;
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
  // end::answer[]

  static void main() {
    new _0002_AddTwoNumbers_2()
      .addTwoNumbers(ListNodes.build(2, 4, 3),
        ListNodes.build(5, 6, 4));
  }
}
