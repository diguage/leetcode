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
 * @since 2019-07-26 08:49
 */
public class _0021_MergeTwoSortedLists {
  // tag::answer[]
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (Objects.isNull(l1) && Objects.isNull(l2)) {
      return null;
    }
    ListNode dummy = new ListNode();
    ListNode tail = dummy;
    while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
      if (l1.val < l2.val) {
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;
    }
    if (Objects.isNull(l1)) {
      tail.next = l2;
    }
    if (Objects.isNull(l2)) {
      tail.next = l1;
    }
    return dummy.next;
  }

  /**
   * Runtime: 1 ms, faster than 28.15% of Java online submissions for Merge Two Sorted Lists.
   *
   * Memory Usage: 39.8 MB, less than 14.45% of Java online submissions for Merge Two Sorted Lists.
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (Objects.isNull(l1)) {
      return l2;
    }
    if (Objects.isNull(l2)) {
      return l1;
    }
    ListNode result = null;
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode tail = null;

    while (Objects.nonNull(p1) && Objects.nonNull(p2)) {
      int v1 = p1.val;
      int v2 = p2.val;
      ListNode temp = null;
      if (v1 < v2) {
        temp = p1;
        p1 = p1.next;
      } else {
        temp = p2;
        p2 = p2.next;
      }
      if (Objects.isNull(tail)) {
        result = temp;
        tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }
    }
    if (Objects.isNull(p1)) {
      tail.next = p2;
    }

    if (Objects.isNull(p2)) {
      tail.next = p1;
    }

    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0021_MergeTwoSortedLists solution = new _0021_MergeTwoSortedLists();
    ListNode l1 = build(Arrays.asList());
    ListNode l2 = build(Arrays.asList());
    ListNode r1 = solution.mergeTwoLists(l1, l2);
    System.out.println(isOrder(r1));
  }
}
