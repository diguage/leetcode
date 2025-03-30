package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * = 23. Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/[(8) Merge k Sorted Lists - LeetCode]
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * .Example:
 * [source]
 * ----
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 20:13:49
 */
public class _0023_MergeKSortedLists_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-02 20:13:49
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (Objects.isNull(lists) || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (ListNode node : lists) {
      if (node != null) {
        queue.offer(node);
      }
    }
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      cur.next = node;
      cur = cur.next;
      if (node.next != null) {
        queue.offer(node.next);
      }
    }
    return dummy.next;
  }
  // end::answer[]
}

