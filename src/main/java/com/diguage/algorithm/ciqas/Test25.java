package com.diguage.algorithm.ciqas;

import com.diguage.algorithm.util.ListNode;
import com.diguage.algorithm.util.ListNodeUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * {@link com.diguage.algorithm.leetcode._0021_MergeTwoSortedLists}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 20:29
 */
public class Test25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(Integer.MIN_VALUE);
        ListNode current = dumpy;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (Objects.isNull(l1) && Objects.nonNull(l2)) {
            current.next = l2;
        }
        if (Objects.isNull(l2) && Objects.nonNull(l1)) {
            current.next = l1;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        Test25 test = new Test25();
        ListNode r1 = test.mergeTwoLists(
                ListNodeUtils.build(Arrays.asList(1, 2, 3)),
                ListNodeUtils.build(Arrays.asList(1, 3, 4)));
        ListNodeUtils.printListNode(r1);
    }

}
