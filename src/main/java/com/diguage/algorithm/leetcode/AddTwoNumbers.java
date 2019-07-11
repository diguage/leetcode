package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 2. Add Two Numbers
 * <p>
 * https://leetcode.com/problems/add-two-numbers/description/[Add Two Numbers - LeetCode]
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * .Example:
 * [source]
 * ----
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-09-17 11:42
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode mergeList = null;
        int carryOver = 0;
        while (Objects.nonNull(h1) && Objects.nonNull(h2)) {
            int v1 = h1.val;
            int v2 = h2.val;
            int newVal = v1 + v2 + carryOver;
            if (newVal >= 10) {
                carryOver = 1;
                newVal -= 10;
            } else {
                carryOver = 0;
            }
            ListNode listNode = new ListNode(newVal);
            listNode.next = mergeList;
            mergeList = listNode;
            h1 = h1.next;
            h2 = h2.next;
        }

        ListNode rest = null;
        if (Objects.nonNull(h1)) {
            rest = h1;
        }
        if (Objects.nonNull(h2)) {
            rest = h2;
        }

        ListNode restHead = rest;
        while (Objects.nonNull(rest) && carryOver > 0) {
            int newVal = rest.val + carryOver;
            if (newVal >= 10) {
                carryOver = 1;
                newVal -= 10;
            } else {
                carryOver = 0;
            }
            rest.val = newVal;
            if (Objects.isNull(rest.next) && carryOver > 0) {
                ListNode carryNode = new ListNode(carryOver);
                rest.next = carryNode;
                carryOver = 0;
            }
            rest = rest.next;
        }
        if (Objects.isNull(restHead) && carryOver > 0) {
            restHead = new ListNode(carryOver);
        }

        while (Objects.nonNull(mergeList)) {
            ListNode next = mergeList.next;
            mergeList.next = restHead;
            restHead = mergeList;
            mergeList = next;
        }

        return restHead;
    }


    public static void main(String[] args) {
        AddTwoNumbers result = new AddTwoNumbers();
        ListNode list1 = result.convertNumberToList(1);
        ListNode list2 = result.convertNumberToList(99);
        ListNode sum = result.addTwoNumbers(list1, list2);
        iterate(sum);
    }


    public ListNode convertNumberToList(int number) {
        ListNode result = null;
        for (int i = number; i > 0; i /= 10) {
            int vaule = i % 10;
            ListNode listNode = new ListNode(vaule);
            if (Objects.isNull(result)) {
                result = listNode;
            } else {
                ListNode last = result;
                while (Objects.nonNull(last.next)) {
                    last = last.next;
                }
                last.next = listNode;
            }
        }
        return result;
    }

    public static void iterate(ListNode header) {
        System.out.println("\n");
        while (Objects.nonNull(header)) {
            System.out.print(header.val + "→");
            header = header.next;
        }
        System.out.println("\n");
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
