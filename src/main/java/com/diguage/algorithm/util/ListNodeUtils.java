package com.diguage.algorithm.util;

import java.util.List;
import java.util.Objects;

/**
 * ListNode 工具类
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-29 21:07
 */
public class ListNodeUtils {
    public static boolean isOrder(ListNode head) {
        if (Objects.isNull(head)) {
            return true;
        }
        System.out.println("\n--------");
        int last = head.val;
        ListNode pointer = head;
        while (Objects.nonNull(pointer)) {
            int current = pointer.val;
            System.out.print(current + ", ");
            if (last > current) {
                return false;
            }
            last = current;
            pointer = pointer.next;
        }
        System.out.println("\n--------");
        return true;
    }

    public static ListNode generate(List<Integer> num) {
        if (Objects.isNull(num) || num.size() == 0) {
            return null;
        }
        ListNode result = null;
        ListNode tail = null;

        for (int i = 0; i < num.size(); i++) {
            int no = num.get(i);
            ListNode node = new ListNode(no);
            if (Objects.isNull(result)) {
                result = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return result;
    }

    public static void printListNode(ListNode header) {
        System.out.println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        while (Objects.nonNull(header)) {
            System.out.print(header.val + "→");
            header = header.next;
        }
        System.out.println("\n↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }
}