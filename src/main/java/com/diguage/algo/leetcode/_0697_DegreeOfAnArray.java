package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0697_DegreeOfAnArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-29 09:15:49
   */
  public int findShortestSubArray(int[] nums) {
    Map<Integer, List<Integer>> numToIndex = new HashMap<>();
    Map<Integer, Integer> indexToDegre = new HashMap<>();
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      List<Integer> index = numToIndex.get(num);
      if (index == null) {
        index = new ArrayList<>();
        index.add(i);
        index.add(i);
        numToIndex.put(num, index);
      } else {
        index.set(1, i);
      }
      int count = indexToDegre.getOrDefault(num, 0) + 1;
      max = Math.max(max, count);
      indexToDegre.put(num, count);
    }
    int minLength = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> entry : indexToDegre.entrySet()) {
      if (max == entry.getValue()) {
        List<Integer> index = numToIndex.get(entry.getKey());
        minLength = Math.min(minLength, index.get(1) - index.get(0));
      }
    }
    return minLength + 1;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0697_DegreeOfAnArray()
      .findShortestSubArray(new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2});
  }
}
