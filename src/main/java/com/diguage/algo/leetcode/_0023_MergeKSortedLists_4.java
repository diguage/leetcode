package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Objects;

public class _0023_MergeKSortedLists_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-03 19:04:38
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (Objects.isNull(lists) || lists.length == 0) {
      return null;
    }
    return mergeLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeLists(ListNode[] lists, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return lists[start];
    }
    int mid = start + (end - start) / 2;
    ListNode left = mergeLists(lists, start, mid);
    ListNode right = mergeLists(lists, mid + 1, end);
    return mergeLists(left, right);
  }

  private ListNode mergeLists(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }
    if (Objects.nonNull(left)) {
      cur.next = left;
    }
    if (Objects.nonNull(right)) {
      cur.next = right;
    }
    return dummy.next;
  }
  // end::answer[]
}
