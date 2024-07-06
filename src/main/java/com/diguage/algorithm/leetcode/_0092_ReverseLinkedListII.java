package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Objects;

import static com.diguage.util.ListNodes.build;
import static com.diguage.util.ListNodes.printListNode;
import static java.util.Arrays.asList;

/**
 * = 92. Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/[Reverse Linked List II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 22:46
 */
public class _0092_ReverseLinkedListII {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 36.6 MB, less than 11.36% of Java online submissions for Reverse Linked List II.
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode reverseList = new ListNode(0);
        ListNode reverseTail = null;
        for (int i = 1; i <= n && Objects.nonNull(head); i++) {
            ListNode next = head.next;
            if (i < m) {
                tail = head;
            } else {
                if (i == m) {
                    reverseTail = head;
                }
                ListNode rNext = reverseList.next;
                reverseList.next = head;
                head.next = rNext;
            }
            head = next;
        }
        if (Objects.nonNull(reverseTail)) {
            reverseTail.next = head;
        }
        tail.next = reverseList.next;
        return dummy.next;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0092_ReverseLinkedListII solution = new _0092_ReverseLinkedListII();
        ListNode r1 = solution.reverseBetween(build(asList(1, 2, 3, 4, 5)), 2, 4);
        printListNode(r1);
    }
}
