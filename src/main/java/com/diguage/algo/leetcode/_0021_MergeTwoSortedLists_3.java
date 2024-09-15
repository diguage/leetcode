package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

public class _0021_MergeTwoSortedLists_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-02 19:43:59
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      // 升序链表，则把最小的留下，其余的进行递归。
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
  // end::answer[]
}
