package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.JsonUtils;
import com.diguage.algorithm.util.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;

/**
 * = 142. Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/[Linked List Cycle II - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-28 08:52
 */
public class _0142_LinkedListCycleII {

    /**
     * Runtime: 1 ms, faster than 32.38% of Java online submissions for Linked List Cycle II.
     * Memory Usage: 41.2 MB, less than 6.32% of Java online submissions for Linked List Cycle II.
     */
    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode intersect = getIntersect(head);
        if (Objects.isNull(intersect)) {
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = intersect;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    private ListNode getIntersect(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode tortoise = head;
        ListNode hare = head;
        while (Objects.nonNull(hare) && Objects.nonNull(hare.next)) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (Objects.equals(tortoise, hare)) {
                return tortoise;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _0142_LinkedListCycleII solution = new _0142_LinkedListCycleII();
        ListNode l1 = build(Arrays.asList(3, 2, 0, -4));
        l1.next.next.next.next = l1.next;
        ListNode listNode = solution.detectCycle(l1);
        System.out.println(JsonUtils.toJson(listNode));
    }
}
