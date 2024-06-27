package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 2. Add Two Numbers
 *
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
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-09-17 11:42
 */
public class _0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode h1 = l1;
//        ListNode h2 = l2;
//        ListNode mergeList = null;
//        int carryOver = 0;
//        while (Objects.nonNull(h1) && Objects.nonNull(h2)) {
//            int v1 = h1.val;
//            int v2 = h2.val;
//            int newVal = v1 + v2 + carryOver;
//            if (newVal >= 10) {
//                carryOver = 1;
//                newVal -= 10;
//            } else {
//                carryOver = 0;
//            }
//            ListNode listNode = new ListNode(newVal);
//            listNode.next = mergeList;
//            mergeList = listNode;
//            h1 = h1.next;
//            h2 = h2.next;
//        }
//
//        ListNode rest = null;
//        if (Objects.nonNull(h1)) {
//            rest = h1;
//        }
//        if (Objects.nonNull(h2)) {
//            rest = h2;
//        }
//
//        ListNode restHead = rest;
//        while (Objects.nonNull(rest) && carryOver > 0) {
//            int newVal = rest.val + carryOver;
//            if (newVal >= 10) {
//                carryOver = 1;
//                newVal -= 10;
//            } else {
//                carryOver = 0;
//            }
//            rest.val = newVal;
//            if (Objects.isNull(rest.next) && carryOver > 0) {
//                ListNode carryNode = new ListNode(carryOver);
//                rest.next = carryNode;
//                carryOver = 0;
//            }
//            rest = rest.next;
//        }
//        if (Objects.isNull(restHead) && carryOver > 0) {
//            restHead = new ListNode(carryOver);
//        }
//
//        while (Objects.nonNull(mergeList)) {
//            ListNode next = mergeList.next;
//            mergeList.next = restHead;
//            restHead = mergeList;
//            mergeList = next;
//        }
//
//        return restHead;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
        ListNode result = l1;
        int digit = 0;
        while (Objects.nonNull(l1.next) && Objects.nonNull(l2.next)) {
            int sum = l1.val + l2.val + digit;
            l1.val = sum % 10;
            digit = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        int sum = l1.val + l2.val + digit;
        l1.val = sum % 10;
        digit = sum / 10;
        if (Objects.isNull(l1.next) && Objects.nonNull(l2.next)) {
            l1.next = l2.next;
            l1 = l1.next;
        }
        ListNode tail = null;
        ;
        while (digit > 0 && Objects.nonNull(l1)) {
            tail = l1;
            sum = l1.val + digit;
            l1.val = sum % 10;
            digit = sum / 10;
            l1 = l1.next;
        }
        if (digit > 0) {
            tail.next = new ListNode(digit);
        }
        return result;
//        ListNode result = l1;
//        int digit = 0;
//        while (Objects.nonNull(l1.next) && Objects.nonNull(l2.next)) {
//            int sum = l1.val + l2.val + digit;
//            l1.val = sum % 10;
//            digit = sum / 10;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        int sum = l1.val + l2.val + digit;
//        l1.val = sum % 10;
//        digit = sum / 10;
//        if (Objects.isNull(l1.next) && Objects.nonNull(l2.next)) {
//            l1.next = l2.next;
//            l1 = l1.next;
//        }
//        while (digit > 0 && Objects.nonNull(l1.next)) {
//            sum = l1.val + digit;
//            l1.val = sum % 10;
//            digit = sum / 10;
//            l1 = l1.next;
//        }
//        if (digit > 0) {
//            l1.next = new ListNode(digit);
//        }
//        return result;
    }


    public static void main(String[] args) {
        _0002_AddTwoNumbers result = new _0002_AddTwoNumbers();
//        ListNode list1 = result.convertNumberToList(1);
//        ListNode list2 = result.convertNumberToList(99);
//        ListNode sum = result.addTwoNumbers(list1, list2);
//        printListNode(sum);
        ListNode list = result.addTwoNumbers(ListNodes.build(Arrays.asList(9, 8)), ListNodes.build(Arrays.asList(8)));
        ListNodes.printListNode(list);
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
}
