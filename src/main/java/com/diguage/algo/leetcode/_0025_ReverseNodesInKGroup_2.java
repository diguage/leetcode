package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Objects;

public class _0025_ReverseNodesInKGroup_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-01 22:32:23
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    while (cur != null) {
      ListNode temp = cur;
      ListNode next = null;
      boolean flag = false;
      for (int i = 0; i < k - 1 && Objects.nonNull(temp.next); i++) {
        temp = temp.next;
        if (i == k - 2) {
          flag = true;
          next = temp.next;
          temp.next = null;
        }
      }

      if (flag) {
        pre.next = reverse(cur);
        pre = cur;
      } else {
        pre.next = cur;
        break;
      }

      cur = next;
    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }
  // end::answer[]

  static void main() {
    new _0025_ReverseNodesInKGroup_2()
      .reverseKGroup(ListNodes.build(1, 2, 3, 4, 5), 2);
  }
}
