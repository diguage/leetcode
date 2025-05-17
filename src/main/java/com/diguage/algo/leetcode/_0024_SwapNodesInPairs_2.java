package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0024_SwapNodesInPairs_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-17 20:24:01
   */
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prefix = dummy;
    while (prefix != null && prefix.next != null && prefix.next.next != null) {
      ListNode first = prefix.next;
      ListNode second = first.next;
      prefix.next = second;
      first.next = second.next;
      second.next = first;
      prefix = first;
    }
    return dummy.next;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0024_SwapNodesInPairs_2()
      .swapPairs(ListNodes.build(Arrays.asList(1, 2, 3, 4)));
  }
}
