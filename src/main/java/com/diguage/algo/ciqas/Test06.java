package com.diguage.algo.ciqas;

import com.diguage.algo.util.ListNode;
import com.diguage.util.ListNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 20:31
 */
public class Test06 {
    public int[] reversePrint(ListNode head) {
        if (Objects.isNull(head)) {
            return new int[0];
        }
        List<Integer> nums = new ArrayList<>();
        while (Objects.nonNull(head)) {
            nums.add(head.val);
            head = head.next;
        }
        int[] result = new int[nums.size()];
        int r = result.length - 1;
        for (int i = 0; i < nums.size(); i++) {
            result[r--] = nums.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Test06 solution = new Test06();
        int[] r1 = solution.reversePrint(ListNodes.build(Arrays.asList(1, 3, 2)));
        System.out.println(Arrays.toString(r1));
    }
}
