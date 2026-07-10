package com.diguage.algo.leetcode;

import com.diguage.algo.util.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _0817_LinkedListComponents {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-10 23:33:26
   */
  public int numComponents(ListNode head, int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    int result = 0;
    while (head != null) {
      if (set.contains(head.val)) {
        while (Objects.nonNull(head.next) && set.contains(head.next.val)) {
          head = head.next;
        }
        result++;
      }
      head = head.next;
    }
    return result;
  }
  // end::answer[]
}
