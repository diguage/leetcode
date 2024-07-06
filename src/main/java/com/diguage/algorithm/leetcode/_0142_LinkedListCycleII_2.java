package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;
import com.diguage.util.Jsons;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.util.ListNodes.build;

/**
 * = 142. Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/[Linked List Cycle II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 21:08:43
 */
public class _0142_LinkedListCycleII_2 {
  // tag::answer[]

  /**
   *
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    // 检查是否有环
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    // 没有环，直接返回
    if (fast == null || fast.next == null) {
      return null;
    }
    // 寻找环的入口节点
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
  // end::answer[]
}
