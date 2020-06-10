package com.diguage.algorithm.ciqas;

import com.diguage.algorithm.util.ListNode;
import com.diguage.algorithm.util.ListNodeUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * {@link com.diguage.algorithm.leetcode._0206_ReverseLinkedList}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 19:35
 */
public class Test24 {
    //    public ListNode reverseList(ListNode head) {
//        if (Objects.isNull(head) || Objects.isNull(head.next)) {
//            return head;
//        }
//        ListNode p1 = null;
//        ListNode p2 = head;
//        while (Objects.nonNull(p2)) {
//            ListNode temp = p2.next;
//            p2.next = p1;
//            p1 = p2;
//            p2 = temp;
//        }
//        return p1;
//    }

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode next = head.next;
        ListNode result = reverseList(next);
        next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        Test24 test = new Test24();
        ListNode r1 = test.reverseList(ListNodeUtils.build(Arrays.asList(1, 2, 3, 4, 5)));
        ListNodeUtils.printListNode(r1);
    }
}
