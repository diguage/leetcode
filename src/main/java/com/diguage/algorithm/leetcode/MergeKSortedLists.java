package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 23. Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/[(8) Merge k Sorted Lists - LeetCode]
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * .Example:
 * [source]
 * ----
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-22 12:40:12
 */
public class MergeKSortedLists {
    /**
     * Runtime: 40 ms, faster than 20.21% of Java online submissions for Merge k Sorted Lists.
     *
     * Memory Usage: 39.6 MB, less than 74.87% of Java online submissions for Merge k Sorted Lists.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (Objects.nonNull(list)) {
                queue.add(list);
            }
        }

        ListNode result = null;
        ListNode tail = null;
        for (ListNode node = queue.poll(); Objects.nonNull(node); ) {
            if (Objects.isNull(result)) {
                result = node;
            }
            ListNode next = node.next;
            if (Objects.nonNull(next)) {
                queue.add(next);
            }
            if (Objects.nonNull(tail)) {
                tail.next = node;
            }
            tail = node;
            node = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = generate(Arrays.asList(1, 4, 5));
        ListNode node2 = generate(Arrays.asList(1, 3, 4));
        ListNode node3 = generate(Arrays.asList(2, 6));
        ListNode[] lists = new ListNode[]{node1, node2, node3};
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode r1 = solution.mergeKLists(lists);
        System.out.println(isOrder(r1));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static boolean isOrder(ListNode head) {
        if (Objects.isNull(head)) {
            return true;
        }
        System.out.println("\n--------");
        int last = head.val;
        ListNode pointer = head;
        while (Objects.nonNull(pointer)) {
            int current = pointer.val;
            System.out.print(current + ", ");
            if (last > current) {
                return false;
            }
            last = current;
            pointer = pointer.next;
        }
        System.out.println("\n--------");
        return true;
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

