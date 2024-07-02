package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * = 141. Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/[Linked List Cycle - LeetCode]
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer `pos` which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * ----
 *
 * *Follow up:*
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 21:00:01
 */
public class _0141_LinkedListCycle_2 {
  /**
   * 快慢指针
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
