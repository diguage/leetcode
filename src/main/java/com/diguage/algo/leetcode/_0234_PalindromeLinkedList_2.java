package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0234_PalindromeLinkedList_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-23 21:10:20
   */
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode tail = reverse(slow);
    while (tail != null) {
      if (head.val != tail.val) {
        return false;
      }
      head = head.next;
      tail = tail.next;
    }
    return true;
  }

  private ListNode reverse(ListNode slow) {
    ListNode prev = null;
    while (slow != null) {
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    return prev;
  }
  // end::answer[]
}
