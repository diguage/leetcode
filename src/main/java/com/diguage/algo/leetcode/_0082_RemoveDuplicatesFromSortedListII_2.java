package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

/**
 * = 82. Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/[Remove Duplicates from Sorted List II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-03 16:50:50
 */
public class _0082_RemoveDuplicatesFromSortedListII_2 {
  // tag::answer[]

  /**
   * 参考官方题解
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-03 16:50:50
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      if (cur.next.val == cur.next.next.val) {
        // 将重复元素全部删除
        int val = cur.next.val;
        while (cur.next != null && cur.next.val == val) {
          cur.next = cur.next.next;
        }
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }
  // end::answer[]
}
