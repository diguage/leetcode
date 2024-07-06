package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Objects;

import static com.diguage.util.ListNodes.build;
import static com.diguage.util.ListNodes.printListNode;
import static java.util.Arrays.asList;

/**
 * = 24. Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/[Swap Nodes in Pairs - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-03 20:12
 */
public class _0024_SwapNodesInPairs {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * Memory Usage: 37.3 MB, less than 5.50% of Java online submissions for Swap Nodes in Pairs.
     */
    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode result = head.next;
        ListNode prevNode = new ListNode(0);
        prevNode.next = head;
        while (Objects.nonNull(head) && Objects.nonNull(head.next)) {
            ListNode second = head.next;
            head.next = second.next;
            second.next = head;
            prevNode.next = second;
            prevNode = head;
            head = head.next;
        }

        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0024_SwapNodesInPairs solution = new _0024_SwapNodesInPairs();
        ListNode r1 = solution.swapPairs(build(asList(1, 2, 3, 4)));
        printListNode(r1);
    }
}
