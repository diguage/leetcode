package com.diguage.algo.ciqas;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 18:46
 */
public class Test18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dumpy = new ListNode(Integer.MIN_VALUE);
        dumpy.next = head;
        ListNode previous = dumpy;
        ListNode current = dumpy.next;
        while (Objects.nonNull(current)) {
            if (current.val == val) {
                break;
            } else {
                current = current.next;
                previous = previous.next;
            }
        }
        if (Objects.nonNull(current)) {
            previous.next = current.next;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        Test18 test = new Test18();
        test.deleteNode(ListNodes.build(Arrays.asList(4, 5, 1, 9)), 5);
    }
}
