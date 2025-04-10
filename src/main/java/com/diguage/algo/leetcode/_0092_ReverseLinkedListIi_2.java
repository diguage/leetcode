package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0092_ReverseLinkedListIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-10 21:33:16
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    int a = m;
    while (a > 1) {
      pre = head;
      head = head.next;
      a--;
    }
    pre.next = null;
    ListNode[] result = reverse(head, null, n - m + 1);
    head.next = result[1];
    pre.next = result[0];
    return dummy.next;
  }

  private ListNode[] reverse(ListNode head, ListNode pre, int n) {
    if (head == null) {
      return new ListNode[]{pre, null};
    }
    if (n == 1) {
      ListNode next = head.next;
      head.next = pre;
      return new ListNode[]{head, next};
    }
    ListNode[] result = reverse(head.next, head, n - 1);
    head.next = pre;
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0092_ReverseLinkedListIi_2().reverseBetween(ListNodes.build(Arrays.asList(1, 2, 3, 4, 5)), 2, 4);
  }
}
