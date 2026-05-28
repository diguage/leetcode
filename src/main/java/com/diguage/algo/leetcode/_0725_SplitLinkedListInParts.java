package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Arrays;

public class _0725_SplitLinkedListInParts {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-28 22:16:19
   */
  public ListNode[] splitListToParts(ListNode head, int k) {
    if (head == null) {
      return new ListNode[k];
    }
    ListNode curr = head;
    int len = 0;
    while (curr != null) {
      len++;
      curr = curr.next;
    }
    int[] count = new int[k];
    Arrays.fill(count, len / k);
    int diff = len % k;
    for (int i = 0; i < diff; i++) {
      count[i]++;
    }
    ListNode[] result = new ListNode[k];
    int index = 0;
    curr = head;
    ListNode ch = curr;
    ListNode prev = null;
    while (curr != null) {
      prev = curr;
      curr = curr.next;
      count[index]--;
      if (count[index] == 0) {
        result[index] = ch;
        ch = curr;
        prev.next = null;
        index++;
      }
    }
    return result;
  }
  // end::answer[]
}
