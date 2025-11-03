package com.diguage.algo.sort;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

public class MergeSortLinkedList {
  // tag::answer[]

  /**
   * 链表：归并排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-03 21:17:41
   */
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = findMid(head);
    ListNode left = mergeSort(head);
    ListNode right = mergeSort(mid);
    return merge(left, right);
  }

  private ListNode findMid(ListNode head) {
    ListNode pre = head, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;
    return slow;
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }
    curr.next = left != null ? left : right;
    return dummy.next;
  }
  // end::answer[]

  static void main() {
    new MergeSortLinkedList().mergeSort(ListNodes.build(6, 5, 3, 1, 8, 7, 2, 4));
  }
}
