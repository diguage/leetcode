package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Objects;

import static com.diguage.util.ListNodes.build;
import static com.diguage.util.ListNodes.printListNode;
import static java.util.Arrays.asList;

/**
 * = 83. Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/[Remove Duplicates from Sorted List - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-04 22:39
 */
public class _0083_RemoveDuplicatesFromSortedList {
  // tag::answer[]

    /**
     * Runtime: 1 ms, faster than 22.08% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 40 MB, less than 7.14% of Java online submissions for Remove Duplicates from Sorted List.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head.next;
        while (Objects.nonNull(current) && Objects.nonNull(current.next)) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0083_RemoveDuplicatesFromSortedList solution = new _0083_RemoveDuplicatesFromSortedList();
        printListNode(solution.deleteDuplicates(build(asList(1, 2, 2, 3, 3, 3))));
    }
}
