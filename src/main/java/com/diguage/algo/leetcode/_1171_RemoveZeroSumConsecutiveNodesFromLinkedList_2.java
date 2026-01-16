package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-16 21:02:36
   */
  public ListNode removeZeroSumSublists(ListNode head) {
    if (head == null) {
      return head;
    }
    int sum = 0;
    Map<Integer, ListNode> sumToNode = new HashMap<>();
    Map<ListNode, Integer> nodeToSum = new HashMap<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    boolean flag = false;
    while (curr != null) {
      sum += curr.val;
      if (sumToNode.containsKey(sum)) {
        ListNode node = sumToNode.get(sum);
        while (node.next != curr.next) {
          ListNode delete = node.next;
          Integer deleteSum = nodeToSum.get(delete);
          nodeToSum.remove(delete);
          sumToNode.remove(deleteSum);
          node.next = delete.next;
        }
        curr = node.next;
        flag = true;
      } else {
        sumToNode.put(sum, curr);
        nodeToSum.put(curr, sum);
        curr = curr.next;
      }
    }
    return flag ? removeZeroSumSublists(dummy.next) : dummy.next;
  }
  // end::answer[]
  static void main() {
    new _1171_RemoveZeroSumConsecutiveNodesFromLinkedList_2()
      .removeZeroSumSublists(ListNodes.build(Arrays.asList(1, 2, -3, 3, 1)));
  }
}
