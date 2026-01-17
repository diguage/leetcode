package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedList_2 {
  // tag::answer[]
  /**
   * 优化，再优化
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026.01.17 14:21
   */
  public ListNode removeZeroSumSublists(ListNode head) {
    Map<Integer, ListNode> sumToNode = new HashMap<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    sumToNode.put(0, dummy);
    ListNode curr = head;
    int sum = 0;
    while (curr != null) {
      sum += curr.val;
      if (sumToNode.containsKey(sum)) {
        ListNode node = sumToNode.get(sum);
        ListNode delete = node.next;
        node.next = curr.next;
        int dSum = sum;
        while (delete != curr) {
          dSum += delete.val;
          sumToNode.remove(dSum);
          delete = delete.next;
        }
      } else {
        sumToNode.put(sum, curr);
      }
      curr = curr.next;
    }
    return dummy.next;
  }

  // end::answer[]
  static void main() {
    new _1171_RemoveZeroSumConsecutiveNodesFromLinkedList_2()
//      .removeZeroSumSublists(ListNodes.build(Arrays.asList(2, 2, -2, 1, -1, -1)));
      .removeZeroSumSublists(ListNodes.build(Arrays.asList(0, 0)));
  }
}
