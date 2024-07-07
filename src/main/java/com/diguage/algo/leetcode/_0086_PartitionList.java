package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.Objects;

import static com.diguage.util.ListNodes.build;
import static com.diguage.util.ListNodes.printListNode;
import static java.util.Arrays.asList;

/**
 * = 86. Partition List
 *
 * https://leetcode.com/problems/partition-list/[Partition List - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 19:14
 */
public class _0086_PartitionList {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
     * Memory Usage: 37.5 MB, less than 5.77% of Java online submissions for Partition List.
     */
    public ListNode partition(ListNode head, int x) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);
        ListNode tailSmall = dummySmall;
        ListNode tailLarge = dummyLarge;
        while (Objects.nonNull(head)) {
            if (head.val < x) {
                tailSmall.next = head;
                tailSmall = tailSmall.next;
            } else {
                tailLarge.next = head;
                tailLarge = tailLarge.next;
            }
            head = head.next;
        }
        tailLarge.next = null;
        tailSmall.next = dummyLarge.next;

        return dummySmall.next;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0086_PartitionList solution = new _0086_PartitionList();
        printListNode(solution.partition(build(asList(1, 4, 3, 2, 5, 2)), 3));
    }
}
