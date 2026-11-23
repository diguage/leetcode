package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Objects;

public class _0025_ReverseNodesInKGroup_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-23 23:41:43
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    int cnt = 0;
    ListNode cur = head;
    while (Objects.nonNull(cur)) {
      cnt++;
      cur = cur.next;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode tail = dummy;
    ListNode pre = dummy;
    cur = head;
    while (cnt >= k) {
      for (int i = 0; i < k; i++) {
        pre = pre.next;
        cnt--;
      }
      ListNode temp = pre.next;
      pre.next = null;

      tail.next = reverse(cur, null);
      tail = cur;
      cur = temp;
      pre = new ListNode(0);
      pre.next = cur;
    }
    tail.next = cur;
    return dummy.next;
  }

  private ListNode reverse(ListNode cur, ListNode prev) {
    if (Objects.isNull(cur)) {
      return prev;
    }
    ListNode next = cur.next;
    cur.next = prev;
    return reverse(next, cur);
  }
  // end::answer[]
  static void main() {
    new _0025_ReverseNodesInKGroup_3().reverseKGroup(ListNodes.build(1, 2, 3, 4, 5), 3);
  }
}
