package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;
import static com.diguage.algorithm.util.ListNodeUtils.printListNode;

/**
 * = 206. Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/[Reverse Linked List - LeetCode]
 *
 * Reverse a singly linked list.
 *
 * .Example:
 * [source]
 * ----
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * ----
 *
 * *Follow up:*
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-12 12:47
 */
public class _0206_ReverseLinkedList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     *
     * Memory Usage: 38 MB, less than 6.48% of Java online submissions for Reverse Linked List.
     */
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode result = null;
        ListNode current = head;
        while (Objects.nonNull(current)) {
            ListNode pre = current.next;
            current.next = result;
            result = current;
            current = pre;
        }
        return result;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     *
     * Memory Usage: 37.8 MB, less than 51.44% of Java online submissions for Reverse Linked List.
     */
    public ListNode reverseListRecursion(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        // 这个反转地方，还要再仔细推敲一下！！
        ListNode node = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        _0206_ReverseLinkedList solution = new _0206_ReverseLinkedList();
        ListNode r1 = solution.reverseList(build(Arrays.asList(1, 2, 3, 4, 5)));
        printListNode(r1);
    }
}
