package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedList {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-03 23:25:31
   */
  public ListNode removeZeroSumSublists(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode curr = dummy;
    int sum = 0;
    while (curr != null) {
      sum += curr.val;
      map.put(sum, curr);
      curr = curr.next;
    }
    sum = 0;
    curr = dummy;
    while (curr != null) {
      sum += curr.val;
      // map 中必然存在 key=sum 的值
      curr.next = map.get(sum).next;
      curr = curr.next;
    }
    return dummy.next;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1171_RemoveZeroSumConsecutiveNodesFromLinkedList()
      .removeZeroSumSublists(ListNodes.build(Arrays.asList(1, 2, -3, 3, 1)));
  }
}
