package com.diguage.algo.ciqas;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 19:16
 */
public class Test22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (Objects.isNull(head) || k < 0) {
            return head;
        }
        ListNode h = head;
        while (k > 0) {
            h = h.next;
            k--;
            if (Objects.isNull(h)) {
                return head;
            }
        }
        ListNode t = head;
        while (Objects.nonNull(h.next)) {
            h = h.next;
            t = t.next;
        }
        return t.next;
    }

    public static void main(String[] args) {
        Test22 test = new Test22();
        ListNode r1 = test.getKthFromEnd(ListNodes.build(Arrays.asList(1, 2, 3, 4, 5, 6)), 0);
        ListNodes.printListNode(r1);
    }
}
