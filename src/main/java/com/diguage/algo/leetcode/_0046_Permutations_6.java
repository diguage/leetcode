package com.diguage.algo.leetcode;

import java.util.*;

public class _0046_Permutations_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-12 22:14:40
   */
  public List<List<Integer>> permute(int[] nums) {
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.offer(List.of(nums[0]));
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        List<Integer> temp = queue.poll();
        for (int k = 0; k <= temp.size(); k++) {
          List<Integer> next = new ArrayList<>(temp);
          next.add(k, num);
          queue.offer(next);
        }
      }
    }
    return new ArrayList<>(queue);
  }
  // end::answer[]

  static void main() {
    new _0046_Permutations_6().permute(new int[]{1, 2, 3});
  }
}
