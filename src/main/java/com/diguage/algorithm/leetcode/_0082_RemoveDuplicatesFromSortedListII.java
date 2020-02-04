package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;
import static com.diguage.algorithm.util.ListNodeUtils.printListNode;
import static java.util.Arrays.asList;

/**
 * = 82. Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/[Remove Duplicates from Sorted List II - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-04 22:58
 */
public class _0082_RemoveDuplicatesFromSortedListII {

    /**
     * Runtime: 1 ms, faster than 60.61% of Java online submissions for Remove Duplicates from Sorted List II.
     * Memory Usage: 39.4 MB, less than 6.98% of Java online submissions for Remove Duplicates from Sorted List II.
     *
     * Copy from: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/kuai-man-zhi-zhen-by-powcai-2/[递归与非递归 - 删除排序链表中的重复元素 II - 力扣（LeetCode）]
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (Objects.nonNull(fast)) {
            while (Objects.nonNull(fast.next) && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next == fast) {
                slow = slow.next;
            } else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        _0082_RemoveDuplicatesFromSortedListII solution = new _0082_RemoveDuplicatesFromSortedListII();
        printListNode(solution.deleteDuplicates(build(asList(1, 2, 3, 3, 4, 4, 5))));
    }
}
