package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;
import static com.diguage.algorithm.util.ListNodeUtils.printListNode;

/**
 * = 328. Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/[Odd Even Linked List - LeetCode]
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * ----
 *
 * *Note:*
 *
 * * The relative order inside both the even and odd groups should remain as it was in the input.
 * * The first node is considered odd, the second node even and so on ...
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-12 12:20
 */
public class _0328_OddEvenLinkedList {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
     *
     * Memory Usage: 38 MB, less than 12.50% of Java online submissions for Odd Even Linked List.
     *
     * Copy from: https://leetcode.com/problems/odd-even-linked-list/solution/[Odd Even Linked List solution - LeetCode]
     */
    public ListNode oddEvenList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (Objects.nonNull(even) && Objects.nonNull(even.next)) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        _0328_OddEvenLinkedList solution = new _0328_OddEvenLinkedList();
        ListNode r1 = solution.oddEvenList(build(Arrays.asList(1, 2, 3, 4, 5)));
        printListNode(r1);
    }
}
