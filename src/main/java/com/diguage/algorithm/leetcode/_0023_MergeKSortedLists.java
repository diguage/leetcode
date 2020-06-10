package com.diguage.algorithm.leetcode;

import java.util.*;

import com.diguage.algorithm.util.ListNode;

import static com.diguage.algorithm.util.ListNodeUtils.*;

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
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-22 12:40:12
 */
public class _0023_MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> heap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
    for (ListNode l : lists) {
      if (Objects.nonNull(l)) {
        heap.add(l);
      }
    }
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (!heap.isEmpty()) {
      ListNode node = heap.poll();
      curr.next = node;
      curr = curr.next;
      if (Objects.nonNull(node.next)) {
        heap.add(node.next);
      }
    }
    return dummy.next;
  }

  /**
   * Runtime: 40 ms, faster than 20.21% of Java online submissions for Merge k Sorted Lists.
   *
   * Memory Usage: 39.6 MB, less than 74.87% of Java online submissions for Merge k Sorted Lists.
   */
  public ListNode mergeKLists1(ListNode[] lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (ListNode list : lists) {
      if (Objects.nonNull(list)) {
        queue.add(list);
      }
    }

    ListNode result = null;
    ListNode tail = null;
    for (ListNode node = queue.poll(); Objects.nonNull(node); ) {
      if (Objects.isNull(result)) {
        result = node;
      }
      ListNode next = node.next;
      if (Objects.nonNull(next)) {
        queue.add(next);
      }
      if (Objects.nonNull(tail)) {
        tail.next = node;
      }
      tail = node;
      node = queue.poll();
    }

    return result;
  }

  public static void main(String[] args) {
    ListNode node1 = build(Arrays.asList(1, 4, 5));
    ListNode node2 = build(Arrays.asList(1, 3, 4));
    ListNode node3 = build(Arrays.asList(2, 6));
    ListNode[] lists = new ListNode[]{node1, node2, node3};
    _0023_MergeKSortedLists solution = new _0023_MergeKSortedLists();
    ListNode r1 = solution.mergeKLists(lists);
    System.out.println(isOrder(r1));
  }
}

