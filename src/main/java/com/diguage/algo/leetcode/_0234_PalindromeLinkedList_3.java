package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

public class _0234_PalindromeLinkedList_3 {

  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-30 22:11:27
   */
  private ListNode curr;
  boolean result = true;
  boolean flag = false;

  public boolean isPalindrome(ListNode head) {
    this.curr = head;
    dfs(head);
    return result;
  }

  private void dfs(ListNode head) {
    if (head == null || !result) {
      return;
    }
    dfs(head.next);
    if (flag) {
      return;
    }
    if (curr == head) {
      flag = true;
      return;
    }
    if (!flag && head.val != curr.val) {
      result = false;
      flag = true;
      return;
    }
    curr = curr.next;
  }

  // end::answer[]
  static void main() {
    new _0234_PalindromeLinkedList_3().isPalindrome(ListNodes.build(1, 0, 1));
  }
}
