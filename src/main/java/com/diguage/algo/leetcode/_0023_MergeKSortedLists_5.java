package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class _0023_MergeKSortedLists_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-25 23:31:43
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (Objects.isNull(lists) || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
    for (ListNode node : lists) {
      if (Objects.nonNull(node)) {
        pq.offer(node);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      head.next = node;
      head = head.next;
      if (node.next != null) {
        pq.offer(node.next);
      }
    }
    return dummy.next;
  }
  // end::answer[]
}
