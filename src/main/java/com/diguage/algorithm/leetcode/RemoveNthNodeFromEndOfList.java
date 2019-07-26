package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * = 19. Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/[Remove Nth Node From End of List - LeetCode]
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * .Example 1:
 * [source]
 * ----
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * ----
 *
 * *Note:*
 *
 * Given n will always be valid.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-07-26 20:17
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     *
     * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (Objects.isNull(head) || n == 0) {
            return head;
        }
        ListNode p1 = head;
        int length = 1;
        while (Objects.nonNull(p1.next) && length <= n) {
            p1 = p1.next;
            length++;
        }
        if (Objects.isNull(p1.next) && length == n) {
            return head.next;
        }
        if (Objects.isNull(p1.next) && length < n) {
            return head;
        }

        ListNode p2 = head;
        while (Objects.nonNull(p1.next)) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (Objects.nonNull(p2.next)) {
            p2.next = p2.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

        ListNode r5 = solution.removeNthFromEnd(generate(Arrays.asList(1, 2)), 1);
        print(r5);

        ListNode r4 = solution.removeNthFromEnd(generate(Arrays.asList(1)), 1);
        print(r4);

        ListNode r1 = solution.removeNthFromEnd(generate(Arrays.asList(1, 2, 3, 4, 5)), 2);
        print(r1);

        ListNode r2 = solution.removeNthFromEnd(generate(Arrays.asList(1, 2, 3, 4, 5)), 6);
        print(r2);

        ListNode r3 = solution.removeNthFromEnd(generate(Arrays.asList()), 2);
        print(r3);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void print(ListNode head) {
        if (Objects.isNull(head)) {
            return;
        }
        System.out.println("\n--------");
        ListNode pointer = head;
        while (Objects.nonNull(pointer)) {
            int current = pointer.val;
            System.out.print(current + ", ");
            pointer = pointer.next;
        }
        System.out.println("\n--------");
    }

    private static ListNode generate(List<Integer> num) {
        if (Objects.isNull(num) || num.size() == 0) {
            return null;
        }
        ListNode result = null;
        ListNode tail = null;

        for (int i = 0; i < num.size(); i++) {
            int no = num.get(i);
            ListNode node = new ListNode(no);
            if (Objects.isNull(result)) {
                result = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return result;
    }
}