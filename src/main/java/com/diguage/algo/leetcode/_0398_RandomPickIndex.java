package com.diguage.algo.leetcode;

import java.util.*;

public class _0398_RandomPickIndex {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-01 22:46:30
   */
  class Solution {
    private Map<Integer, List<Integer>> numToIndex = new HashMap<>();
    private Random random;

    public Solution(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        numToIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
      }
      random = new Random();
    }

    public int pick(int target) {
      List<Integer> index = numToIndex.get(target);
      return index.get(random.nextInt(index.size()));
    }
  }
  // end::answer[]
}
