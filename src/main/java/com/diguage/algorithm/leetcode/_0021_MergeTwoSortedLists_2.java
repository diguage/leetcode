package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.util.ListNodes.build;
import static com.diguage.util.ListNodes.isOrder;

/**
 * = 21. Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/[Merge Two Sorted Lists - LeetCode]
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * .Example:
 * [source]
 * ----
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 19:43:59
 */
public class _0021_MergeTwoSortedLists_2 {
  // tag::answer[]
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (Objects.isNull(l1)) {
      return l2;
    }
    if (Objects.isNull(l2)) {
      return l1;
    }
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else if (l2.val < l1.val) {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;

      if (l1 == null) {
        curr.next = l2;
        break;
      }
      if (l2 == null) {
        curr.next = l1;
        break;
      }
    }
    return dummy.next;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0021_MergeTwoSortedLists_2 solution = new _0021_MergeTwoSortedLists_2();
    ListNode l1 = build(Arrays.asList());
    ListNode l2 = build(Arrays.asList());
    ListNode r1 = solution.mergeTwoLists(l1, l2);
    System.out.println(isOrder(r1));
  }
}
