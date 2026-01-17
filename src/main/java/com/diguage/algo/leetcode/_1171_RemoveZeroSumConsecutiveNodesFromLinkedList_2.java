package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _1171_RemoveZeroSumConsecutiveNodesFromLinkedList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-16 21:02:36
   */
  public ListNode removeZeroSumSublists(ListNode head) {
    Map<Integer, ListNode> sumToNode = new HashMap<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode curr = head;
    while (Objects.nonNull(curr)) {
      if (0 == curr.val) {
        pre.next = curr.next;
      } else {
        pre = curr;
      }
      curr = curr.next;
    }
    int sum = 0;
    curr = dummy;
    while (curr != null) {
      sum += curr.val;
      if (sumToNode.containsKey(sum)) {
        ListNode node = sumToNode.get(sum);
        int dSum = sum;
        while (node.next != curr.next) {
          ListNode delete = node.next;
          dSum += delete.val;
          if (dSum != sum) {
            sumToNode.remove(dSum);
          }
          node.next = delete.next;
        }
        curr = node.next;
      } else {
        sumToNode.put(sum, curr);
        curr = curr.next;
      }
    }
    return dummy.next;
  }

  // end::answer[]
  static void main() {
    new _1171_RemoveZeroSumConsecutiveNodesFromLinkedList_2()
      .removeZeroSumSublists(ListNodes.build(Arrays.asList(2, 2, -2, 1, -1, -1)));
//      .removeZeroSumSublists(ListNodes.build(Arrays.asList(0, 0)));
  }
}
