package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.util.ListNodes.build;

/**
 * = 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 1->2
 * Output: false
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 1->2->2->1
 * Output: true
 * ----
 *
 * *Follow up:*
 *
 * Could you do it in O(n) time and O(1) space?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-13 19:58
 */
public class _0234_PalindromeLinkedList {

    /**
     * Runtime: 1 ms, faster than 99.33% of Java online submissions for Palindrome Linked List.
     *
     * Memory Usage: 41.5 MB, less than 41.46% of Java online submissions for Palindrome Linked List.
     */
    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);
        fast = head;
        while (Objects.nonNull(slow)) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (Objects.nonNull(head)) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }

    public static void main(String[] args) {
        _0234_PalindromeLinkedList solution = new _0234_PalindromeLinkedList();
        boolean r1 = solution.isPalindrome(build(Arrays.asList(1, 2, 3, 2, 1)));
        System.out.println(r1);
        boolean r2 = solution.isPalindrome(build(Arrays.asList(1, 2, 3, 3, 2, 1)));
        System.out.println(r2);
        boolean r3 = solution.isPalindrome(build(Arrays.asList(1, 2)));
        System.out.println(r3);
    }
}
