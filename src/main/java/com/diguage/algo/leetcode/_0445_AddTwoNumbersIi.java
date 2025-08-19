package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;

public class _0445_AddTwoNumbersIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-19 22:06:27
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode len = null;
    ListNode c1 = l1, c2 = l2;
    while (c1 != null && c2 != null) {
      c1 = c1.next;
      c2 = c2.next;
      if (c1 == null && c2 == null) {
        break;
      } else if (c1 == null) {
        len = l2;
        c1 = l2;
        break;
      } else if (c2 == null) {
        len = l1;
        c2 = l1;
        break;
      }
    }
    if (c1 == null && c2 == null) {
      // 两个链表长度相等，则直接相加即可
      ListNode result = add1(l1, l2);
      return result.val == 0 ? result.next : result;
    } else {
      // 长度不等，则将链表以短链表的长度为准分割成收尾两部分
      while (c1 != null && c1.next != null
        && c2 != null && c2.next != null) {
        c1 = c1.next;
        c2 = c2.next;
      }
      if (c1.next == null) {
        c1 = l2;
        ListNode tmp = c2.next;
        c2.next = null;
        c2 = tmp;
      } else if (c2.next == null) {
        c2 = l1;
        ListNode tmp = c1.next;
        c1.next = null;
        c1 = tmp;
      }
      // 尾部直接相加
      ListNode tail = add1(c1, c2);
      // 将尾部“嫁接”到首部
      ListNode result = add2(len, tail);
      return result.val == 0 ? result.next : result;
    }
  }

  private ListNode add2(ListNode len, ListNode tail) {
    ListNode result;
    if (len.next == null) {
      result = tail;
    } else {
      result = add2(len.next, tail);
    }
    int sum = len.val + result.val;
    ListNode head = new ListNode(sum / 10);
    head.next = result;
    result.val = sum % 10;
    return head;
  }

  private ListNode add1(ListNode l1, ListNode l2) {
    if ((l1 != null && l1.next == null)
      && (l2 != null && l2.next == null)) {
      int sum = l1.val + l2.val;
      ListNode head = new ListNode(sum / 10);
      head.next = new ListNode(sum % 10);
      return head;
    }
    ListNode result = add1(l1.next, l2.next);
    int sum = l1.val + l2.val + result.val;
    ListNode head = new ListNode(sum / 10);
    head.next = result;
    result.val = sum % 10;
    return head;
  }
  // end::answer[]
  public static void main(String[] args) {
    ListNode result = new _0445_AddTwoNumbersIi().addTwoNumbers(
      ListNodes.build(Arrays.asList(7, 2, 4)),
      ListNodes.build(Arrays.asList(5, 6, 4)));
    System.out.println(result);
  }
}
