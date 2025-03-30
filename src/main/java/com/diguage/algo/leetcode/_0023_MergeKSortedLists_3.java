package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class _0023_MergeKSortedLists_3 {
  // tag::answer[]
/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2025-03-30 23:20:44
 */
public ListNode mergeKLists(ListNode[] lists) {
  if (Objects.isNull(lists) || lists.length == 0) {
    return null;
  }
  // 注意：这里使用一个虚拟头节点，方便后续的操作
  ListNode dummy = new ListNode(0);
  // 自定义 Comparator，对堆内的 ListNode 头节点数字做排序
  PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
  for (ListNode node : lists) {
    if (Objects.nonNull(node)) {
      pq.offer(node);
    }
  }
  ListNode current = dummy;
  while (!pq.isEmpty()) {
    ListNode node = pq.poll();
    current.next = node;
    current = node;
    ListNode next = node.next;
    node.next = null;
    if (Objects.nonNull(next)) {
      pq.offer(next);
    }
  }
  return dummy.next;
}
  // end::answer[]
}
