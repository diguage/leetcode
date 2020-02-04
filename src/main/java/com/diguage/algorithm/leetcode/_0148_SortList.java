package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;
import static com.diguage.algorithm.util.ListNodeUtils.printListNode;

/**
 * = 148. Sort List
 *
 * https://leetcode.com/problems/sort-list/[Sort List - LeetCode]
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * ----
 *
 * .Example 1:
 * [source]
 * ----
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-29 21:05
 */
public class _0148_SortList {

    /**
     * Runtime: 4 ms, faster than 62.99% of Java online submissions for Sort List.
     *
     * Memory Usage: 40.2 MB, less than 89.47% of Java online submissions for Sort List.
     */
    public ListNode sortList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode firstResult = sortList(head);
        ListNode secondResult = sortList(slow);

        return merge(firstResult, secondResult);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (Objects.nonNull(first) && Objects.nonNull(second)) {
            if (first.val < second.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        if (Objects.isNull(first)) {
            tail.next = second;
        }
        if (Objects.isNull(second)) {
            tail.next = first;
        }
        return result.next;
    }


    public static void main(String[] args) {
        _0148_SortList solution = new _0148_SortList();

        ListNode list1 = build(Arrays.asList(4, 2, 1, 3));
        printListNode(list1);
        ListNode re1 = solution.sortList(list1);
        printListNode(re1);
    }
}
