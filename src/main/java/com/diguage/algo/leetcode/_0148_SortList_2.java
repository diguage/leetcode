package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0148_SortList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-08 15:06:31
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // 分
    ListNode pre = head, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null; // 将链表切成两段
    // 治
    ListNode r1 = sortList(head);
    ListNode r2 = sortList(slow);
    // 合
    return merge(r1, r2);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode cur = result;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null) {
      cur.next = l1;
    }
    if (l2 != null) {
      cur.next = l2;
    }
    return result.next;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0148_SortList_2().sortList(ListNodes.build(Arrays.asList(4, 2, 1, 3)));
  }
}
