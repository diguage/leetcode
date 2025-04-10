package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0046_Permutations_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-10 17:22:39
   */
  public List<List<Integer>> permute(int[] nums) {
    Queue<List<Integer>> result = new LinkedList<>();
    result.offer(new ArrayList<>(List.of(nums[0])));
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      int size = result.size();
      for (int j = 0; j < size; j++) {
        List<Integer> tmp = result.poll();
        for (int k = 0; k <= tmp.size(); k++) {
          List<Integer> adding = new ArrayList<>(tmp);
          if (k == tmp.size()) {
            adding.add(num);
          } else {
            adding.add(k, num);
          }
          result.offer(adding);
        }
      }
    }
    return new ArrayList<>(result);
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0046_Permutations_5().permute(new int[]{1, 2, 3});
  }
}
