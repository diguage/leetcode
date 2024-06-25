package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;
import com.diguage.algorithm.util.ListNodeUtils;

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
 * @since 2020-01-12 10:06
 */
public class _0141_LinkedListCycle {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     *
     * Memory Usage: 37.9 MB, less than 84.29% of Java online submissions for Linked List Cycle.
     */
    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (Objects.nonNull(fast)) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (Objects.nonNull(fast)) {
                fast = fast.next;
            }
        }
        return false;
    }

    /**
     * Runtime: 5 ms, faster than 6.60% of Java online submissions for Linked List Cycle.
     *
     * Memory Usage: 38.3 MB, less than 82.14% of Java online submissions for Linked List Cycle.
     *
     * Copy from: https://leetcode.com/problems/linked-list-cycle/solution/[Linked List Cycle solution - LeetCode]
     */
    public boolean hasCycleMap(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode current = head;
        while (Objects.nonNull(current)) {
            if (nodes.contains(current)) {
                return true;
            } else {
                nodes.add(current);
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        _0141_LinkedListCycle solution = new _0141_LinkedListCycle();
        ListNode l1 = ListNodeUtils.build(Arrays.asList(3, 2, 0, -4));
        l1.next.next.next.next = l1.next;
        boolean r1 = solution.hasCycle(l1);
        System.out.println(r1);
    }
}
