package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;
import static com.diguage.algorithm.util.ListNodeUtils.printListNode;
import static java.util.Arrays.asList;

/**
 * = 61. Rotate List
 *
 * https://leetcode.com/problems/rotate-list/[Rotate List - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-01 23:11
 */
public class _0061_RotateList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
     * Memory Usage: 38.8 MB, less than 46.55% of Java online submissions for Rotate List.
     *
     * Copy from: https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/[旋转链表 - 旋转链表 - 力扣（LeetCode）]
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || k == 0) {
            return head;
        }

        ListNode current = head;
        int length;
        for (length = 1; Objects.nonNull(current.next); length++) {
            current = current.next;
        }

        int pass = length - k % length;
        if (pass == length || pass == 0) {
            return head;
        }
        current.next = head;

        current = head;
        for (int i = 0; i < pass - 1; i++) {
            current = current.next;
        }
        ListNode result = current.next;
        current.next = null;

        return result;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
     * Memory Usage: 38.7 MB, less than 55.17% of Java online submissions for Rotate List.
     */
    public ListNode rotateRightLoop(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode current = head;
        int length = 0;
        while (Objects.nonNull(current)) {
            length++;
            current = current.next;
        }
        int pass = length - k % length;
        if (pass == length || pass == 0) {
            return head;
        }
        current = head;
        for (int i = 0; i < pass - 1; i++) {
            current = current.next;
        }
        ListNode result = current.next;
        current.next = null;
        current = result;
        while (Objects.nonNull(current)) {
            if (Objects.isNull(current.next)) {
                break;
            }
            current = current.next;
        }
        current.next = head;

        return result;
    }

    public static void main(String[] args) {
        _0061_RotateList solution = new _0061_RotateList();
        printListNode(solution.rotateRight(build(asList(1, 2, 3, 4, 5)), 2));
        printListNode(solution.rotateRight(build(asList(0, 1, 2)), 4));
    }
}
