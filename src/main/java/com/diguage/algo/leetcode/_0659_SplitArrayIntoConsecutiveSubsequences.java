package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0659_SplitArrayIntoConsecutiveSubsequences {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-25 20:29:50
   */
  public boolean isPossible(int[] nums) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int num : nums) {
      if (!map.containsKey(num)) {
        map.put(num, new PriorityQueue<>());
      }
      if (map.containsKey(num - 1)) {
        Integer prevLength = map.get(num - 1).poll();
        if (map.get(num - 1).isEmpty()) {
          map.remove(num - 1);
        }
        map.get(num).offer(prevLength + 1);
      } else {
        map.get(num).offer(1);
      }
    }
    for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
      if (entry.getValue().peek() < 3) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
  static void main() {
    new _0659_SplitArrayIntoConsecutiveSubsequences()
      .isPossible(new int[]{1, 2, 3, 4, 5, 5, 6, 7});
  }
}
